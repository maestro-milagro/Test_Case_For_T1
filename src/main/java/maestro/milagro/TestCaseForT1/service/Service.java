package maestro.milagro.TestCaseForT1.service;

import maestro.milagro.TestCaseForT1.model.RequestDTO;
import maestro.milagro.TestCaseForT1.model.ResponseDTO;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Service
public class Service {

    public ResponseDTO sortMessage(RequestDTO request){
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> frequencies = new HashMap<>();
        String message = request.getMessage();
        for (int i = 0; i < message.length()-1; i++) {
            frequencies.put(message.substring(i, i+1), message.length()-message.replace(message.substring(i, i+1), "").length());
        }
        frequencies.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue()))
                .forEach(c -> sb.append("'").append(c.getKey()).append("': ").append(c.getValue()).append(", "));
        String answer = sb.toString().strip();
        return new ResponseDTO(answer.substring(0, answer.length()-1));
    }
}
