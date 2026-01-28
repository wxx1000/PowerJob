package tech.powerjob.server.web.controller;

import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.powerjob.common.enums.TimeExpressionType;
import tech.powerjob.common.response.ResultDTO;
import tech.powerjob.server.core.scheduler.TimingStrategyService;

import java.util.List;

/**
 * 校验控制器
 *
 * @author tjq
 * @author Echo009
 * @since 2020/11/28
 */
@RestController
@RequestMapping("/validate")
@RequiredArgsConstructor
public class ValidateController {

    private final TimingStrategyService timingStrategyService;

    @GetMapping("/timeExpression")
    public ResultDTO<List<String>> checkTimeExpression(@RequestParam("timeExpressionType") TimeExpressionType timeExpressionType,
                                                       @RequestParam("timeExpression") String timeExpression,
                                                       @RequestParam(name = "startTime", required = false) Long startTime,
                                                       @RequestParam(name = "endTime", required = false) Long endTime
    ) {
        try {
            timingStrategyService.validate(timeExpressionType, timeExpression, startTime, endTime);
            return ResultDTO.success(timingStrategyService.calculateNextTriggerTimes(timeExpressionType, timeExpression, startTime, endTime));
        } catch (Exception e) {
            return ResultDTO.success(Lists.newArrayList(ExceptionUtils.getMessage(e)));
        }
    }
}
