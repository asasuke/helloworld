package com.herokuapp.asasuke_helloworld;

import static spark.Spark.*;

public class MyApplication {
	public static void main(String[] args) {

		port(Integer.valueOf(System.getenv("PORT")));

        get("/hello", (req, res) -> "Hello World");
    }
}
