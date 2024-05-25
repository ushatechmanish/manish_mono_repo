package in.ushatech.api.core.composite;


  public record ServiceAddresses(
    String compositeAddress,
    String productAddress,
    String reviewAddress,
    String recommendationAddress) {

    public ServiceAddresses() {
      this(null,null,null,null);
    }
  }


