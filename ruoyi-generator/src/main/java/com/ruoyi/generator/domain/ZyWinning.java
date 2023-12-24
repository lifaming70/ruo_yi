package com.ruoyi.generator.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZyWinning {

    private Integer winningId;
    private Integer userId;
    private Integer lotteryId;
    private Integer createTime;
}
