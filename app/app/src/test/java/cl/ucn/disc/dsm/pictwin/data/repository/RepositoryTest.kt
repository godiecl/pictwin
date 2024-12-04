/*
 * Copyright (c) 2024. Departamento de Ingenieria de Sistemas y Computacion.
 */

package cl.ucn.disc.dsm.pictwin.data.repository

import cl.ucn.disc.dsm.pictwin.data.network.NetworkModule
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.slf4j.LoggerFactory

/**
 * Test: Repository.
 */
class RepositoryTest {

    // the logger
    private var log = LoggerFactory.getLogger(Repository::class.java)

    private lateinit var repository: Repository

    /**
     * Before each test.
     */
    @Before
    fun setup() {
        val gson = NetworkModule.provideGson()
        val api = NetworkModule.provideApiService(gson)

        repository = Repository(api)
    }

    /**
     * Testing Authenticate.
     */
    @Test
    fun testAuthenticate() {
        runBlocking {
            log.debug("Testing authenticate() ..")

            val result = repository.authenticate("durrutia@ucn.cl", "durrutia123")

            // Optional: Add assertions to verify the result
            result.onSuccess {
                log.debug("Authentication successful: {}", it)
            }.onFailure {
                log.error("Authentication failed", it)
                Assert.fail("Authentication failed !!")
            }
        }
    }
}




