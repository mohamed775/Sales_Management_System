package com.pluralsight.project.dtos.requests;

import com.pluralsight.project.validations.annotations.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
public class ActionRequest {



    private String descriptionAr ;
    private String descriptionEn ;

    @NotNull(message = "Trace Id must not be null", groups = Save.class)
    @Min(value = 1,message = "Trace Id must not be empty", groups = {Save.class, Update.class})
    @UniqueTraceId(groups = {Save.class, Update.class})
    private String traceId;

    @NotNull(message = "User Id must not be null", groups = Save.class)
    @Min(value = 1,message = "User Id must not be empty", groups = {Save.class, Update.class})
    @UserExists(groups = {Save.class, Update.class})
    private Long user;

    @NotNull(message = "Action Type Id must not be null", groups = Save.class)
    @Min(value = 1,message = "Action Type Id must not be empty", groups = {Save.class, Update.class})
    @ActionTypeExists(groups = {Save.class, Update.class})
    private Long actionType;

    @ApplicationExists(groups = {Save.class, Update.class})
    private Long application;

    @BEExists(groups = {Save.class, Update.class})
    private Long be;

    private List<ParamRequest> params;

    public interface Save {}

    public interface Update {}

}
