package com.example.demo;


import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    static ArrayList<Node> familyRoot;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        familyRoot = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        Stack<Node> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            String name = in.next();
            String parent = in.next();
            int birth = in.nextInt();
            String death = in.next();
            String religion = in.next();
            String gender = in.next();
            familyRoot.add(new Node(name, parent, birth, death, religion, gender));
            System.err.println(name + " | " + parent + " | " + birth + " | " + death + " | " + religion + " | " + gender);

        }

        stack.push(familyRoot.get(0));
        familyRoot.remove(0);

        Comparator<Node> myComparator = new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                if (n1.gender.equals("M") && n2.gender.equals("F")) {
                    return 1;
                } else if (n1.gender.equals(n2.gender)) {
                    if (n1.birth < n2.birth) {
                        return 1;
                    }
                }
                return -1;
            }
        };

        // 정렬
        while (!stack.isEmpty()) {
            Node parentNode = stack.pop();
            queue.offer(parentNode);
            ArrayList<Node> tempArray = new ArrayList<>();

            // 이 for문이 종료되면 자식들을 tempArray에 담는다
            for (int i = 0; i < familyRoot.size(); i++) {
                Node thisNode = familyRoot.get(i);
                if (thisNode.parent.equals(parentNode.name)) {
                    tempArray.add(thisNode);
                }
            }

            // 자식들을 정렬
            Collections.sort(tempArray, myComparator);

            for (int i = 0; i < tempArray.size(); i++) {
                stack.push(tempArray.get(i));
                familyRoot.remove(tempArray.get(i));
            }


        }



        // 출력 : 가톨릭, 생존 여부 판별하여 출력
        while (!queue.isEmpty()) {
            Node thisNode = queue.poll();
            if (thisNode.death.equals("-") && thisNode.religion.equals("Anglican")) {
                System.out.println(thisNode.name);
            }
        }
    }

}

class Node {
    String name;
    String parent;
    int birth;
    String death;
    String religion;
    String gender;

    Node(String name, String parent, int birth, String death, String religion, String gender) {
        this.name = name;
        this.parent = parent;
        this.birth = birth;
        this.death = death;
        this.religion = religion;
        this.gender = gender;
    }

}