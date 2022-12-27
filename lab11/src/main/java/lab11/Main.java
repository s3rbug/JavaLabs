package lab11;

import java.sql.ResultSet;

public class Main {

    public static void main(String[] args) {
        try (Database db = new Database()) {
            ResultSet workersSet = db.statement.executeQuery("SELECT * from workers");
            System.out.println("All workers: ");
            db.printWorkers(workersSet);
            ResultSet tasksSet = db.statement.executeQuery("SELECT * from task");
            System.out.println("All tasks: ");
            db.printTasks(tasksSet);
            String positionType = "position2";
            ResultSet workersPositionSet = db.statement.executeQuery("SELECT * from workers WHERE position='" + positionType + "'");
            System.out.println("All workers with position type " + positionType + ": ");
            db.printWorkers(workersPositionSet);
            String newTaskDescription = "new_task_description";
            int newTaskWorkerId = 1;
            db.statement.executeUpdate("INSERT task(workerId, description) VALUES(" + newTaskWorkerId  + ", '" + newTaskDescription + "')");
            System.out.println("Added task to worker id: " + newTaskWorkerId + ", its description: " + newTaskDescription);
            tasksSet = db.statement.executeQuery("SELECT * from task");
            System.out.println("All tasks: ");
            db.printTasks(tasksSet);
            String workerNameToFind = "name2";
            String workerSurnameToFind = "surname2";
            ResultSet foundWorker = db.statement.executeQuery("SELECT * FROM workers WHERE name='" + workerNameToFind + "' AND surname='" + workerSurnameToFind + "'");
            System.out.println("Found workers for name " + workerNameToFind + " and surname " + workerSurnameToFind + ": ");
            db.printWorkers(foundWorker);
            int workerIdToDelete = 6;
            int changed = db.statement.executeUpdate("DELETE FROM workers WHERE id='" + workerIdToDelete + "'");
            if (changed == 0) {
                System.out.println("Worker with id " + workerIdToDelete + " does not exist");
            } else {
                System.out.println("Deleted worker id: " + workerIdToDelete);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}