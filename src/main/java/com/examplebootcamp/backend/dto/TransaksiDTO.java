package com.examplebootcamp.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

public class TransaksiDTO {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class New {
        @NotNull
        private Double kuantitas;
        @NotNull
        private Integer produk_id;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Update {
        @NotNull
        private Integer id;
        @NotNull
        private Integer kuantitas;
        @NotNull
        private Integer produk_id;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Detail {
        @NotNull
        private Integer id;
        @NotNull
        private String produk;
        @NotNull
        private String produsen;
        @NotNull
        private Double harga;
        @NotNull
        private Integer kuantitas;
        @NotNull
        private Double totalHarga;
    }
}
