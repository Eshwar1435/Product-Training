import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static ArrayList<Customer> cusList = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);
        int loginChoice = 0;
        do {
            System.out.println("****************** Welcome to ToDo List Application************************");
            System.out.println("1. Admin\n2. Customer\n3. exit \nSelect login option");

            loginChoice = in.nextInt();
            switch (loginChoice) {
                case 1:
                    System.out.println("**************** Welcome to ToDo List Application ***************");
                    System.out.println("Enter userName:");
                    String userName = in.next();
                    in.nextLine();
                    System.out.println("Enter Password:");
                    String password = in.next();
                    if (userName.equals("Admin") && password.equals("Admin@123")) {
                        System.out.println("Admin login successful");
                        int adminChoice = 0;
                        do {
                            System.out.println(
                                    "1. Add Customer\n2. Delete Customer\n3.Edit Customer\n4. view Customer\n5. Exit");
                            adminChoice = in.nextInt();
                            switch (adminChoice) {
                                case 1:
                                    Customer c = new Customer();
                                    System.out.println("Enter Customer id : ");
                                    int cid = in.nextInt();
                                    System.out.println("Enter Customer name : ");
                                    String cName = in.next();
                                    System.out.println("Enter userName : ");
                                    String username = in.next();
                                    System.out.println("Enter password : ");
                                    String Password = in.next();
                                    c.setCid(cid);
                                    c.setcName(cName);
                                    c.setUserName(username);
                                    c.setPassword(Password);
                                    cusList.add(c);
                                    break;
                                case 2:
                                    System.out.println("Enter the cid to be Deleted");
                                    int dcid = in.nextInt();
                                    int falgd = 0;
                                    for (int i = 0; i < cusList.size(); i++) {
                                        if (cusList.get(i).getCid() == dcid) {
                                            cusList.remove(i);
                                            falgd = 1;
                                            break;
                                        }
                                    }
                                    if (falgd == 0) {
                                        System.out.println("No customer is found :");
                                    }
                                    break;
                                case 3:
                                    System.out.println("Enter the cid which want ot edit : ");
                                    int ecid = in.nextInt();
                                    int flage = 0;
                                    for (int i = 0; i < cusList.size(); i++) {
                                        if (cusList.get(i).getCid() == ecid) {
                                            System.out.println("Edit\n1. Cname\n2. username\n3. password\n 4. exit");
                                            int eid = in.nextInt();
                                            switch (eid) {
                                                case 1:
                                                    System.out.println("Enter the Customer Name : ");
                                                    String ename = in.next();
                                                    in.nextLine();
                                                    cusList.get(i).setcName(ename);
                                                    break;
                                                case 2:
                                                    System.out.println("Enter the user Name : ");
                                                    String euname = in.next();
                                                    in.nextLine();
                                                    cusList.get(i).setUserName(euname);
                                                    break;
                                                case 3:
                                                    System.out.println("Enter the password : ");
                                                    String epassword = in.next();
                                                    in.nextLine();
                                                    cusList.get(i).setPassword(epassword);
                                                    break;
                                                case 4:
                                                    break;

                                                default:
                                                    break;
                                            }
                                            flage = 1;
                                            break;
                                        }
                                    }
                                    if (flage == 0) {
                                        System.out.println("No Customer Found ");
                                    }
                                    break;
                                case 4:
                                    System.out.println("Enter cid to view deatils : ");
                                    int vcid = in.nextInt();
                                    for (Customer x : cusList) {
                                        if (x.getCid() == vcid) {
                                            System.out.printf("cid : %d%n cName : %s%n userName : %s%n password : %s%n",
                                                    x.getCid(), x.getcName(), x.getUserName(), x.getPassword());
                                        }
                                    }
                                    break;
                                case 5:
                                    break;

                                default:
                                    break;
                            }
                        } while (adminChoice != 5);

                    }
                    break;
                case 2:
                    System.out.println("******* Welcome to ToDo List **********");
                    System.out.println("Enter Cutomer login details : ");
                    System.out.println("Enter User Name");
                    String uName = in.next();
                    System.out.println("Enter password");
                    String upassword = in.next();
                    Customer loged = null;
                    boolean flag = false;
                    ArrayList<Task> taskList = new ArrayList<>();
                    for (Customer x : cusList) {
                        if (x.getUserName().equals(uName) && x.getPassword().equals(upassword)) {
                            System.out.println("Log in  successful");
                            loged = x;
                            taskList = x.getTaskList();
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        int customerChoice = 0;
                        do {
                            System.out.println(
                                    "1. Add Task\n2. Delete Task\n3.Edit Task\n4. view Task\n5. Exit");
                            customerChoice = in.nextInt();
                            switch (customerChoice) {
                                case 1:
                                    Task t = new Task();
                                    System.out.println("Enter Task Id:");
                                    int tid = in.nextInt();
                                    System.out.println("Enter Task Name : ");
                                    String tname = in.next();
                                    in.nextLine();
                                    System.out.println("Enter Task Description");
                                    String tDisp = in.nextLine();
                                    System.out.println("Task status");
                                    String tstaus = in.next();
                                    t.setCreatedBy(loged.getCid());
                                    t.setTaskid(tid);
                                    t.setTaskName(tname);
                                    t.setTaskDiscription(tDisp);
                                    t.setTaskstatus(tstaus);
                                    taskList.add(t);
                                    break;
                                case 2:
                                    System.out.println("Enter task id :");
                                    int dtid = in.nextInt();
                                    for (int i = 0; i < taskList.size(); i++) {
                                        if (taskList.get(i).getTaskid() == dtid) {
                                            taskList.remove(i);
                                            break;
                                        }
                                    }
                                    break;
                                case 3:
                                    System.out.println("Enter task Id : ");
                                    int etid = in.nextInt();
                                    for (Task x : taskList) {
                                        if (x.getTaskid() == etid) {
                                            System.out
                                                    .println("1. taskName\n2. taskDescription\n3. taskStatus\n4. exit");
                                            int taskChoice = in.nextInt();
                                            switch (taskChoice) {
                                                case 1:
                                                    System.out.println("Enter task name : ");
                                                    String etname = in.next();
                                                    x.setTaskName(etname);
                                                    break;
                                                case 2:
                                                    System.out.println("Enter task Description");
                                                    String etdis = in.nextLine();
                                                    x.setTaskDiscription(etdis);
                                                    break;
                                                case 3:
                                                    System.out.println("Enter task status");
                                                    String etstatus = in.next();
                                                    x.setTaskstatus(etstatus);
                                                    break;
                                                case 4:
                                                    break;
                                                default:
                                                    break;
                                            }
                                            break;
                                        }
                                    }
                                    break;
                                case 4:
                                    System.out.println("Enter task id : ");
                                    int vtid = in.nextInt();
                                    for (Task x : taskList) {
                                        if (x.getTaskid() == vtid) {
                                            System.out.printf(
                                                    "task id : %d%n TaskName : %s%n TaskDescrption: %s%n TaskStatus: %s%n",
                                                    x.getTaskid(), x.getTaskName(), x.getTaskDiscription(),
                                                    x.getTaskstatus());
                                            break;
                                        }
                                    }
                                    break;
                                case 5:
                                    break;

                                default:
                                    break;
                            }

                        } while (customerChoice != 5);
                    } else
                        System.out.println("incorrect username or password or no account exists");
                    break;

                case 3:
                    break;
                default:
                    break;
            }
        } while (loginChoice != 3);
        in.close();
    }
}
