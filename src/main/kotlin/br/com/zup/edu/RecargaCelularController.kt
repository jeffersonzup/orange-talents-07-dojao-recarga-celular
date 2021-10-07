package br.com.zup.edu

import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import javax.validation.Valid

@Validated
@Controller("/api/recargaCelular")
class RecargaCelularController(val recargaCelularRepository: RecargaCelularRepository) {

    @Post
    fun recarrega(@Body @Valid request: RecargaCelularRequest):HttpResponse<Any>{
        val recargaCelular = request.paraRecargaCelular()
        if(recargaCelular.numeroTelefone.endsWith("3")){
            return HttpResponse.status<Any?>(HttpStatus.SERVICE_UNAVAILABLE).body("Operadora indisponível")
        }
        recargaCelularRepository.save(recargaCelular)
        return HttpResponse.ok()
    }
}