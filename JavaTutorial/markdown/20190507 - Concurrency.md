# 20190507 - Concurrency

## 1) Overview

concurrent software : 하나의 어플리케이션에서 여러가지 동작을 동시에 할 수 있는 소프트웨어

`java.util.concurrent` 패키지에서 concurrent programming을 할 수 있는 High level api를 제공함.

### 1-1. Processes and Threads

Threads, processes : **basic units of execution**

자바에서는 대부분 Thread를 잘 다루는 형식으로 작동함.

1. Processes : **self-contained execution** environments.

   * run-time resources
   * memory space

   프로세스는 application 이랑은 다른 개념임.

   * 한 어플리케이션에서 여러 process들을 사용함

   * OS는 여러 프로세스들의 교류를 위해서 **IPC**(inter processes communication)을 지원함.

     * socket, pipe :  IPC를 위한 통로
     * 물론 다른 어플리케이션의 프로세스와도 IPC가 가능함.

   * 자바에서는 대부분 **Single process 환경**을 다루지만,

     [ProcessBuilder](<https://docs.oracle.com/javase/8/docs/api/java/lang/ProcessBuilder.html>) 오브젝트를 통해서 프로세스를 추가할 수 있음.

2. Thread : **lightweight** processes

   * 새로운  쓰레드를 만드는건 프로세스를 만드는거보다 저렴함.
   * 쓰레드들은 기반이 되는 프로세스의 자원을 공유함.
   * 처음에는 main thread로부터 시작함
     * main thread는 추가적인 쓰레드르 만들 수 있음.



## 2) Thread Objects

우리가 다루는 쓰레드는 `Thread` 클래스의 인스턴스랑 관련있음.

concurrent application을 이용하기 위한 기본적인 두 방법들

* 비동기적인 작업을 시작하기 위해서 Thread 클래스 객체를 만들어서 컨트롤하기

* To abstract thread management from the rest of your application, pass the application's tasks to an *executor*.

  (무슨말인지 모르겠음..)

### 2-1. Defining and Starting a Thread

`Thread` 클래스의 객체를 생성했으면,

우리 코드를 쓰레드 위에서 실행시켜야 하는데, 그 방법은 두가지가 있음.

1. `Runnable` 객체를 생성함.

   * Runnable 인터페이스는 run method밖에 정의가 안되어있음
   * 여기 안에 우리가 실행하고 싶은 코드를 잘 버무려 넣으면 됨.

   ```java
   public class HelloRunnable extends Runnable {
       public void run() {
           // 실행하고 싶은 코드들.
       }
       public static void main(String[] args){
           (new Thread(new HelloRunnable())).start();
       }
   }
   ```

2. `Thread` 클래스 자체를 상속함.

   * 어자피 

