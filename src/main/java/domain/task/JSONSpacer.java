package domain.task;

import com.google.gson.Gson;

/**
 * @author Georgiy Minasian
 */
//spacer between frontend and backend, help to switch JSON string to task object and backwards
public class JSONSpacer {

    Task getTaskFromJSONString(String obj){
        Gson gson = new Gson();
        return gson.fromJson(obj, Task.class);
    }


    String getJSONStringFromTask(Task task) {
        Gson gson = new Gson();
        return gson.toJson(task);
    }
}
