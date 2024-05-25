package in.ushatech.util;

import org.springframework.http.HttpStatus;

  public record  HttpErrorInfo(HttpStatus httpStatus, String path, String message) {
  public HttpErrorInfo()
  {
    this(null, null, null);
  }
  }

