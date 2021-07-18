// int k = 2;
// Node kth = KthToLast(first, k);
// System.out.println("Last k(" + k + ")th data is" + kth.data);
// }
// private static Node KthToLast(Node first, int k) {
//     Node n = first;
//     int total = 1;
//     while (n.next != null) {
//         total++;
//         n=n.next;
//     }
//     n=first;
//     for (int i=1; i<total-k+1; i++) {
//         n=n.next;
//     }
//     return n;
// }

// 뒤부터 세기
public class Test {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.retrieve();
        int k = 3;
        Reference r = new Reference();
        KthToLast(ll.getFirst(), k, r);
        System.out.println(found.data);
    }

    class Reference {
        public int count = 0;
    }

    private static int KthToLast(Node n, int k, Reference r) {
        if (n == null) {
            return null;
        }

        Node found = KthToLast(n.next, k, r);
        r.count++;
        if (r.count == k) {
            return n;
        }
        return found;
    }
}

// 중간노드 삭제
public class Test {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.retrieve();

        deleteNode(ll.get(3));
        ll.retrieve();
    }

    private static boolean deleteNode(Node n) {
        if (n == null || n.next == null) {
            return false;
        }
        Node next = n.next;
        n.data = next.data;
        n.next = next.next;
        return true;
    }
}

// 교차점 찾기
public class Test {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        Node m1 = new Node(5);
        Node m1 = m1.addNext(7);
        Node m1 = m2.addNext(9);
        Node m1 = m3.addNext(10);
        Node m1 = m4.addNext(7);
        Node m1 = m5.addNext(6);

        Node m1 = new Node(1);
        Node m1 = m1.addNext(2);
        Node m1 = m1.addNext(3);
        Node m1 = m1.addNext(4);
        Node m1 = m1.addNext(5);
        Node m1 = m1.addNext(6);
        n1.print();
        m1.print();

        Node n = getIntersection(n1, m1);

        if (n != null) {
            System.out.println("Intersection: " + n.data);
        } else {
            System.out.println("Not found");
        }
    }

    private static Node getIntersection(Node l1, Node l2) {
        int len1 = getListLength(l1);
        int len2 = getListLength()l2;

        if (len1 > len2) {
            l1 = l1.get(len1 - len2);
        } else if (len1 < len2) {
            l2 = l2.get(len2 - len1);
        }

        while (l1 != null && l2 != null) {
            if (l1 == l2) {
                return l1;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return null;
    }
}

// 루프 찾기
public class Test {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = n1.addNext(2);
        Node n3 = n2.addNext(3);
        Node n4 = n3.addNext(4);
        Node n5 = n4.addNext(5);
        Node n6 = n5.addNext(6);
        Node n7 = n6.addNext(7);
        Node n8 = n7.addNext(8);
        n8.addNext(n4);

        Node n = findLoop(n1);

        if (n != null) {
            System.out.println("Start of loop: " + n.data);
        } else {
            System.out.println("Loop not found");
        }
    }

    public static Node findLoop(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;

        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}

// 합산 알고리즘
public class Test {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.append(9);
        l1.append(1);
        l1.append(4);
        l1.retrieve();

        LinkedList l2 = new LinkedList();
        l1.append(6);
        l1.append(4);
        l1.append(3);
        l1.retrieve();

        Node n = sumLists(l1.get(1), l2.get(1), 0);
        while (n.next != null) {
            System.out.print(n.data + "->");
            n = n.next;
        }
        System.out.println(n.data);
    }

    public static Node sumLists(Node l1, Node l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        Node result = new Node();
        int value = carry;

        if (l1 != null) {
            value += l1.data;
        }
        if (l2 != null) {
            value += l2.data;
        }
        result.data = value % 10;

        if (L1 != null || l2 != null) {
            Node next = sumLists(l1 == null ? null : l1.next, l2 == null ? null : l2.next, value >= 10 ? 1 : 0);
            result.next = next;
        }
        return result;
    }
}

// 합산 알고리즘 심화편
class Storage {
    int carry = 0;
    Node result = null;
}

public class Test {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.append(9);
        l1.append(1);
        l1.retrieve();

        LinkedList l2 = new LinkedList();
        l1.append(1);
        l1.append(1);
        l1.retrieve();
    }

    private static Node sumLists(Node l1, Node l2) {
    }

    private static int getListLength(Node l) {
        int total = 0;
        while (l != null) {
            total++;
            l = l.next;
        }
        return tatal;
    }

    private static Node insertBefore(Node node, int data) {
        Node before = new Node(data);
        if (node != null) {
            before.next = node;
        }
        return before;
    }

    private static Node L
}