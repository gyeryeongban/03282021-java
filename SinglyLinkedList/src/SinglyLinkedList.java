class Node { // 시작
    int data; // 노드 안에 데이터가 있음/ 보통 오브젝트를 넣지만 간단하게 정수값 하나 넣음
    Node next = null; // 다음 노드를 가지고 있어야 하니까 노드를 next 라는 이름으로 null을 초기 값을 줌
                      // 마지막 노드는 null에 next를 갖고 있어야 함

    Node(int d) { // 노드를 생성할때 값을 받아서
        this.data = d; // 이 데이터에 넣도록 함
    }

    // 데이터 추가
    // 원래는 성공했는지 추가하고 실패했는지 블링 타입을 리턴해야 되지만 간단하게 만들어 보는거라 일단 넣기만 함
    void append(int d) { // append할 때 데이터 값을 받음
        Node end = new Node(d); // 새로운 노드를 하나 생성/ 맨 마지막에 넣을거니까 end/ 새로운 노드를 이 값으로 만들어라
        Node n = this; // 포인터 하나 생성/ 첫번째 노드 선택하게 함
        while (n.next != null) { // 맨 마지막 노드를 찾아야 되니까 돎/ null이 아닐 때까지만 돌면 됨
            n = n.next; // 다음 .. 다음 .. 다음/ null이 아닐 때까지 찾음/ n의 마지막 값은 마지막 노드를 선택하고 나옴
        }
        n.next = end; // 마지막 노드의 next 값에 새로 생성한 노드를 넣어주면 새로운 애가 맨 마지막 노드가 됨
    }

    // 데이터 삭제
    void delete(int d) { // 삭제할 값을 받음
        Node n = this; // 임의의 포인터를 하나 생성/ 지워야 될 값을 찾아야 되기 때문에 맨 처음 노드를 가르키게 함
        while (n.next != null) { // 노드를 돌면서 마지막 노드가 아닐 때까지 돎
            if (n.next.data == d) { // 만약 n.next.data가 d와 같은지 n.next가 null이 아닐 때까지 하면 마지막 데이터, 마지막 노드에는 가지 않음
                                    // 그냥 앞에서 보고 다음 데이터가 뭔지 확인 후, 지울지 말지를 전 노드에서 확인하는 것이기 때문에 n.next.data임
                n.next = n.next.next; // 만약 앞에 보고있는 노드가 내가 삭제해야 할 노드면 n.next.next로 갈아치움
                                      // 그러면 n.next는 사라지고 그 다음 n.next.next 주소를 갖기 때문에 이 다음 노드는 사라짐
            } else { // 값이 다른 경우에는 다음 노드로 이동해서 계속해서 삭제할 노드를 찾게 됨
                n = n.next;
            }
        } // n이 돌면서 n의 다음 노드와 비교하면 첫번째 노드는 비교를 안하고 넘어감
          // 헤더는 값을 가진 노드이기 전에 링크드 리스트를 대표하는 첫번째 리스트기 때문에
          // 만약 그냥 지우면 다른 오브젝트가 삭제된 헤더를 갖고있는 경우에 문제가 생김
          // 그래서 첫번째 노드는 삭제를 못하는 걸로 코딩함
    }

    // 결과 값을 볼 수 있는 함수
    void retrieve() { // 현재 Linked List에 어떤 노드들이 있는지 나열해서 보여주는 함수를 하나 생성
                      // 쭉쭉 찾아 들어가서 빼내오는 것을 받는 input은 없음
        Node n = this; // 처음부터 찾아야 되니까 노드 포인터를 하나 선언
        while (n.next != null) { // null이 아닐 때까지 돎/ 마지막 노드 전 단계까지 찾아서
            System.out.print(n.data + "->"); // 출력
            n = n.next; // 다음 노드로 이동하면서 계속 출력
        }
        System.out.println(n.data); // 다음 노드로 이동하고 마지막 노드가 되기 전에 나와 마지막 노드를 출력 안함
                                    // 그 전에 이미 n에 마지막 노드를 할당했기 때문에 한번 더 출력/ 마지막 데이터까지 출력
    }
}

public class SinglyLinkedList { // 테스트 클래스 생성
    public static void main(String[] args) {
        Node head = new Node(1); // 헤드 노드 하나 생성/ 시작하는 첫번째 노드 값은 1로 줌
        head.append(2); // 헤드 노드에 다른 노드 2를 추가
        head.append(3); // 헤드 노드에 다른 노드 3를 추가
        head.append(4); // 헤드 노드에 다른 노드 4를 추가
        head.retrieve(); // 출력
        head.delete(2); // 2 지우기
        head.delete(3); // 3 지우기
        head.retrieve(); // 출력
    }
}