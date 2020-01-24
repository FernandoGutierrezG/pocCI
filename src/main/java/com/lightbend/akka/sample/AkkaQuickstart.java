package com.lightbend.akka.sample;

import akka.actor.typed.ActorSystem;

import java.io.IOException;
public class AkkaQuickstart {
  public static void main(String[] args) {
    System.out.println("--------Starting program---------");
    System.out.println("Building with maven ");
    System.out.println("Date ");
    //FernandoGutierrezG
    //http://177.236.52.61:8080/github-webhook/
    // e31aaf5dce0d4ae1587963ad44228661f1a8def
    //#actor-system
    final ActorSystem<GreeterMain.SayHello> greeterMain = ActorSystem.create(GreeterMain.create(), "helloakka");
    //#actor-system

    //#main-send-messages
    greeterMain.tell(new GreeterMain.SayHello("Charles"));
    //#main-send-messages

    try {
      System.out.println(">>> Press ENTER to exit <<<");
      System.in.read();
    } catch (IOException ignored) {
    } finally {
      greeterMain.terminate();
    }
  }
}
