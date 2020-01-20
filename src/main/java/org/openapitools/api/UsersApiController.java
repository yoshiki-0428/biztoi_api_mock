package org.openapitools.api;

import org.openapitools.model.BizToiUser;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.UUID;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-01-17T12:24:45.432663+09:00[Asia/Tokyo]")

@CrossOrigin
@Controller
@RequestMapping("${openapi.bizToi.base-path:/api}")
public class UsersApiController implements UsersApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public UsersApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public ResponseEntity<BizToiUser> userInfo(@NotNull @Valid String code) {
        return ResponseEntity.ok(new BizToiUser()
                .id(UUID.randomUUID().toString())
                .pictureUrl("https://picsum.photos/30/30")
                .nickname("Biztoi Nick")
                .country("jp")
                .email("biztoi.tool@gmail.com")
        );
    }

}
