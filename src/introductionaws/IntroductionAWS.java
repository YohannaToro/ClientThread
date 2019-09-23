/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package introductionaws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author estudiante
 */
public class IntroductionAWS {

    /**
     * @param args the command line arguments
     * @throws InterruptedException
     */

    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (String s : args) {

            try {
                ClientPool urlReader = new ClientPool(new URL(s));
                es.execute(urlReader);
            } catch (IOException e) {
                System.err.println("url wronng");
                System.exit(1);
            }
        }
        es.awaitTermination(1, TimeUnit.MINUTES);
    }
}