package org.openapitools.api;

import org.openapitools.model.Authorize;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-01-17T12:24:45.432663+09:00[Asia/Tokyo]")

@Controller
@RequestMapping("${openapi.bizToi.base-path:/api}")
public class AuthApiController implements AuthApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public AuthApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public ResponseEntity<Authorize> authGetToken(@NotNull @Valid String code) {
        return null;
    }

    @Override
    public ResponseEntity<Void> authLogin(@NotNull @Valid String redirectUri) {
        return null;
    }

}
