package br.com.zup.edu

import io.micronaut.core.annotation.Introspected
import java.math.BigDecimal
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Positive

@Introspected
data class RecargaCelularRequest(
    @field:NotNull val operadora: Operadora,
    @field:NotBlank @field:Pattern(regexp = "[(]?[1-9][0-9][)]?9[0-9]{4}[-]?[0-9]{4}") val numeroTelefone: String,
    @field:NotNull @field:Positive val valor: BigDecimal
) {
    fun limpaNumeroTelefone() : String {
        return numeroTelefone.replace("(","").replace(")", "").replace("-","")
    }

    fun paraRecargaCelular() :RecargaCelular{
        return RecargaCelular(operadora, limpaNumeroTelefone(), valor)
    }

}
