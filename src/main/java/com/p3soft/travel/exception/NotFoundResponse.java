package com.p3soft.travel.exception;

import lombok.Getter;

@Getter
public class NotFoundResponse extends Exception {
   public NotFoundResponse(int code, String message) {
      this.code = code;
      this.message = message;
   }

   private final int code;
   private final String message;
}
