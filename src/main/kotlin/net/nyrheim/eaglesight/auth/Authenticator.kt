package net.nyrheim.eaglesight.auth

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jws
import io.jsonwebtoken.Jwts
import net.nyrheim.eaglesight.database.Database
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets.UTF_8
import java.security.KeyFactory
import java.security.interfaces.RSAPrivateKey
import java.security.spec.PKCS8EncodedKeySpec
import java.time.Duration
import java.time.Instant
import java.time.temporal.ChronoUnit.HOURS
import java.util.*
import kotlin.concurrent.thread

class Authenticator(val database: Database) {

    private val base64Decoder = Base64.getDecoder()
    private val privateKeyPemBegin = "-----BEGIN PRIVATE KEY-----"
    private val privateKeyPemEnd = "-----END PRIVATE KEY-----"
    private val keyFactory = KeyFactory.getInstance("RSA")

    private val key: RSAPrivateKey

    init {
        val keyFile = File("./private.pem")
        if (!keyFile.exists()) {
            val process = ProcessBuilder()
                .command("openssl", "genpkey", "-out", "private.pem", "-algorithm", "RSA", "-pkeyopt", "rsa_keygen_bits:2048")
                .directory(File("."))
                .start()
            thread {
                val reader = BufferedReader(InputStreamReader(process.inputStream))
                var line: String? = ""
                while (line != null) {
                    line = reader.readLine()
                    if (line != null) {
                        println(line)
                    }
                }
                reader.close()
            }
            process.waitFor()
        }
        key = privateKeyFromPem(keyFile.readText(UTF_8))
    }

    private fun privateKeyFromPem(pemfile: String): RSAPrivateKey {
        val bytes = base64Decoder.decode(
                pemfile
                        .replace(privateKeyPemBegin, "")
                        .replace(privateKeyPemEnd, "")
                        .replace("\n", "")
        )
        return keyFactory.generatePrivate(PKCS8EncodedKeySpec(bytes)) as RSAPrivateKey
    }

    fun jwsForApplicationId(applicationId: Int): String? {
        val jws = Jwts.builder()
            .setSubject(applicationId.toString())
            .setExpiration(Date.from(Instant.now().plus(Duration.of(24, HOURS))))
            .signWith(key)
            .compact()
        verify(jws)
        return jws
    }

    fun verify(jws: String): Jws<Claims> {
        val parser = Jwts.parserBuilder().setSigningKey(key).build()
        return parser.parseClaimsJws(jws)
    }

}