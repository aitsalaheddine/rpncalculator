package com.cacib.application.adapters.rest.endpoint;

import com.cacib.application.adapters.rest.model.Request;
import com.cacib.domain.adapter.CalculatorAdapter;
import com.cacib.domain.model.OperatorEnum;
import com.cacib.domain.model.exception.StackNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/rpn")
@OpenAPIDefinition(info = @Info(title = "RPN API", version = "1.0", description = "RPN Calculator"))
@Slf4j
public class CalculatorRestAdapter {

    private final CalculatorAdapter calculatorAdapter;

    public CalculatorRestAdapter(CalculatorAdapter calculatorAdapter) {
        this.calculatorAdapter = calculatorAdapter;
    }

    @GetMapping(value = "/stack")
    public ResponseEntity<String> listAllStacks() throws JsonProcessingException {
        return ResponseEntity.ok(new ObjectMapper().writeValueAsString(calculatorAdapter.listAllStacks()));
    }

    @PostMapping(value = "/stack")
    public ResponseEntity<HttpStatus> createNewStack() {
        log.info("Creating a new stack");
        calculatorAdapter.createStack();
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/stack/{stackId}")
    public ResponseEntity<HttpStatus> pushNewValueToStack(@PathVariable Integer stackId, @RequestBody @Valid Request request) {
        log.info("Pushing new element to Stack " + stackId);
        calculatorAdapter.pushToStack(stackId, request.getValue());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/stack/{stackId}")
    public ResponseEntity<HttpStatus> deleteStack(@PathVariable Integer stackId) {
        calculatorAdapter.deleteStack(stackId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/stack/{stackId}/clear")
    public ResponseEntity<HttpStatus> clearStack(@PathVariable Integer stackId) {
        calculatorAdapter.getStack(stackId).clearStack();
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/op/{op}/stack/{stackId}")
    public ResponseEntity<HttpStatus> calculate(@PathVariable Integer stackId, @PathVariable String op) throws StackNotFoundException {
        calculatorAdapter.calculate(stackId, op);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/op")
    public ResponseEntity<List<OperatorEnum>> getOperations() {
        return ResponseEntity.ok(calculatorAdapter.getOperations());
    }

}
