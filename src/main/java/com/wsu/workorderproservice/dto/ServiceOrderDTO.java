package com.wsu.workorderproservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServiceOrderDTO {
    private Integer id;
    @NotNull(message = "Vehicle ID is mandatory")
    private Integer vin;

    @NotNull(message = "Mechanic ID is mandatory")
    private Integer MID;

    @NotNull(message = "Service ID is mandatory")
    private Integer serviceId;

    @NotNull(message = "Date recieved is mandatory")
    private String dateRecieved;

    @NotNull(message = "Date ompleted is mandatory")
    private String dateCompleted;

    @NotBlank(message = "Status is mandatory")
    private String status;

}
