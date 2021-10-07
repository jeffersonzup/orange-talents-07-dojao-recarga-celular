package br.com.zup.edu

import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Positive

@Entity
class RecargaCelular(
    @field:NotNull @Enumerated(EnumType.STRING) val operadora: Operadora,
    @field:NotBlank @field:Pattern(regexp = "[(]?[1-9][0-9][)]?9[0-9]{4}[-]?[0-9]{4}") val numeroTelefone: String,
    @field:NotNull @field:Positive val valor: BigDecimal
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    val realizadaEm:LocalDateTime = LocalDateTime.now()
}