package com.ouacrimecoders.backoffice.autopartsmanager.criteria;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PackageCriteria {

    private Long id;
    private String name;
    private String active;
    private String isDefault;


}
