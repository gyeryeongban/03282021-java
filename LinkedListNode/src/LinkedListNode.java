class LinkedList { // 노드 클래스를 감싸는 Linked List 라는 클래스를 생성
    Node header; // 헤더 노드 선언

    static class Node { // 노드 선언
        int data; // 노드는 데이터와
        Node next = null; // next 다음 주소 값을 가지게 됨/ 초기 값은 null
    }

    LinkedList() { // Linked List 생성할 때
        header = new Node(); // 헤더 노드를 생성하도록 함
    }

    // 데이터 추가
    void append(int d) { // append할 때 데이터 값을 받음
        Node end = new Node(); // 새로운 노드를 하나 생성/ 맨 마지막에 넣을거니까 end/ 새로운 노드를 이 값으로 만들어라
        end.data = d;
        Node n = header; // 포인터 하나 생성 첫번째 노드 선택하게 함
        while (n.next != null) { // 맨 마지막 노드를 찾아야 되니까 돎/ null이 아닐 때까지만 돌면 됨
            n = n.next; // 다음 .. 다음 .. 다음/ null이 아닐 때까지 찾음/ n의 마지막 값은 마지막 노드를 선택하고 나옴
        }
        n.next = end; // 마지막 노드의 next 값에 새로 생성한 노드를 넣어주면 새로운 애가 맨 마지막 노드가 됨
    }

    // 데이터 삭제
    void delete(int d) { // 삭제할 값을 받음
        Node n = header; // 헤더를 하나 할당해서 시작점으로 운영
        while (n.next != null) { // 노드를 돌면서 마지막 노드가 아닐 때까지 돎
            if (n.next.data == d) { // 만약 n.next.data가 d와 같은지 n.next가 null이 아닐 때까지 하면 마지막 데이터, 마지막 노드에는 가지 않음
                                    // 그냥 앞에서 보고 다음 데이터가 뭔지 확인 후, 지울지 말지를 전 노드에서 확인하는 것이기 때문에 n.next.data임
                n.next = n.next.next; // 만약 앞에 보고있는 노드가 내가 삭제해야 할 노드면 n.next.next로 갈아치움
                                      // 그러면 n.next는 사라지고 그 다음 n.next.next 주소를 갖기 때문에 이 다음 노드는 사라짐
            } else { // 값이 다른 경우에는 다음 노드로 이동해서 계속해서 삭제할 노드를 찾게 됨
                n = n.next;
            }
        }
    } // 이제 더이상 delete에서 첫번째 값을 지우지 않아도 됨
      // = 첫번째 값은 헤더고 헤더는 데이터로 사용되지 않고 관리 용도로만 쓰기 때문에 그 알고리즘 그대로 써도 됨

    // 결과 값을 볼 수 있는 함수
    void retrieve() { // 현재 Linked List에 어떤 노드들이 있는지 나열해서 보여주는 함수를 하나 생성
        Node n = header.next; // 헤더 다음 데이터를 n에 할당해서 n부터 출력하도록 함
        while (n.next != null) { // null이 아닐 때까지 돎/ 마지막 노드 전 단계까지 찾아서
            System.out.print(n.data + "->"); // 출력
            n = n.next; // 다음 노드로 이동하면서 계속 출력
        }
        System.out.println(n.data); // 다음 노드로 이동하고 마지막 노드가 되기 전에 나와 마지막 노드를 출력 안함
                                    // 그 전에 이미 n에 마지막 노드를 할당했기 때문에 한번 더 출력/ 마지막 데이터까지 출력
    }
}

public class LinkedListNode { // 클래스를 테스트 클래스 하나 생성
    public static void main(String[] args) {
        LinkedList ll = new LinkedList(); // 링크드 리스트 하나 선언
        ll.append(1); // 데이터를 append함
        ll.append(2); // 데이터를 append함
        ll.append(3); // 데이터를 append함
        ll.append(4); // 데이터를 append함
        ll.retrieve(); // 출력
        ll.delete(1); // 첫번째 데이터를 delete함/ 이전 시간에 만들었던 코드로는 첫번째 데이터의 값을 지울 수가 없었음
        ll.retrieve(); // 출력
    }
}