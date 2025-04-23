public class CustomException extends Exception {
  public enum Reason {UnknownCommand, ValueTooSmall, ValueTooBig}

  public CustomException(Reason reason) { super(getMessageForReason(reason));}
  private static String getMessageForReason(Reason reason)
  {
    return switch (reason)
    {
        case UnknownCommand -> "Wyjątek ID 1: nieznana komenda";
        case ValueTooSmall -> "Wyjątek ID 2: wartość zbyt mała";
        case ValueTooBig -> "Wyjątek ID 3: wartość zbyt duża";
    };
  }
}
