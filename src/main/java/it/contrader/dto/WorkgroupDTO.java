package it.contrader.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class WorkgroupDTO {
private long idworkgroup;
private String name;
private String members;
private String responsible;
private String work;
}
