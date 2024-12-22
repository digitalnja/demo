package com.ivanlechtmec;

import java.util.ArrayList;
import java.util.List;

public class InvokerOperation {
    private final List<Operation> operationQueue = new ArrayList<>();

    public void addOperation(Operation operation){
        operationQueue.add(operation);
    }
    public void doAllOperation(){
        for(Operation operation : operationQueue){
            operation.doOperation();
        }
    }


}
