class train {
    static Node engine;

    static class Node {
        String data;
        Node next;

        Node(String d) {
            data = d;
            next = null;
        }
    }

    public void insertionAtEnd(String Coach) {
        Node newNode = new Node(Coach);
        if (engine == null) {
            engine = new Node(Coach);
            return;
        }
        newNode.next = null;
        Node temp = engine;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return;
    }

    public static void insertionAtBegin(String Coach) {
        Node newNode = new Node(Coach);
        newNode.next = engine;
        engine = newNode;
    }

    public void insertAtAnyPosition(Node PreCoach, String Coach) {
        if (PreCoach == null) {
            System.out.println("The given previous node cannot be null");
            return;
        }
        Node newNode = new Node(Coach);
        newNode.next = PreCoach.next;
        PreCoach.next = newNode;
    }

    public static void deletionOfCoach(String s) {
        if (engine == null) {
            System.out.println("Train is empty");
            return;
        }
        Node temp = engine;
        Node prev = null;

        if (engine.data.equals(s)) {
            engine = engine.next;
            return;
        }

        while (temp != null && !temp.data.equals(s)) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println(s + "Coach not found");
            return;
        }

        if (prev != null) {
            prev.next = temp.next;
        }

    }

    public void reversalOfTrain() {
        Node currentCoach = engine;
        Node prevCoach = null;
        Node nextCoach = null;
        while (currentCoach != null) {
            nextCoach = currentCoach.next;
            currentCoach.next = prevCoach;
            prevCoach = currentCoach;
            currentCoach = nextCoach;
        }
        engine = prevCoach;
        train.deletionOfCoach("Engine");
        train.insertionAtBegin("Engine");

        return;
    }

    public void displayTrain() {
        Node current = engine;
        while (current != null) {
            System.out.print(current.data + " <==> ");
            current = current.next;
        }
    }
}

class LinkedListTrain {
    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        train train = new train();
        train.insertionAtBegin("Engine");
        train.insertionAtEnd("Coach1");
        train.insertionAtEnd("Coach2");
        train.insertionAtEnd("Coach3");
        train.insertionAtEnd("Coach4");
        train.insertionAtEnd("Coach5");
        train.insertAtAnyPosition(train.engine, "ArmyCoach");
        train.displayTrain();
        System.out.println();
        train.deletionOfCoach("Coach3");
        train.displayTrain();
        train.reversalOfTrain();
        System.out.println();
        train.displayTrain();
    }
}