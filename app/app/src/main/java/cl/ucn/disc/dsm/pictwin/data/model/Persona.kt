package cl.ucn.disc.dsm.pictwin.data.model

/**
 * Data class: Persona
 */
data class Persona(
    val ulid: String,
    val email: String,
    val picTwins: List<PicTwin>,
)


