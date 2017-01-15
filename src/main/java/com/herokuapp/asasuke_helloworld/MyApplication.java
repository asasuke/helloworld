package com.herokuapp.asasuke_helloworld;

import static spark.Spark.*;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import spark.ExceptionHandler;

public class MyApplication {

	private static Logger logger = LoggerFactory.getLogger(MyApplication.class);

	public static void main(String[] args) {



		port(Integer.valueOf(System.getenv("PORT")));
		get("/hello", (req, res) -> {

			return "あーちゃん";
		});


		exception(RuntimeException.class, handleRuntimeException);

    }

	private static ExceptionHandler handleRuntimeException = (e, req, res) -> {
		logger.error("", e);

		res.status(500);

		StringBuffer sb = new StringBuffer();
		Arrays.stream(e.getStackTrace()).forEach(ee -> sb.append(ee.toString() + "<br >"));

		res.body("<html><body><h1>RuntimeException</h1><font color=\"#DA0000\">" + sb.toString() + "</font></body></html>");
	};

}
