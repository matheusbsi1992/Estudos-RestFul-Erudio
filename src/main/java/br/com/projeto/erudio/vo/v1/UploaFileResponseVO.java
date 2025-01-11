package br.com.projeto.erudio.vo.v1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UploaFileResponseVO implements Serializable {

    private String fileName;
    private String fileDownloadUri;
    private String fileType;
    private long size;

}
