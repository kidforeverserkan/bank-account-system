bank-account-system/
├─ README.md
├─ .gitignore
├─ pom.xml                    (or build.gradle if Gradle)
└─ src/
├─ main/
│  ├─ java/
│  │  └─ com/yourname/bank/
│  │     ├─ domain/        (business logic)
│  │     │  ├─ BankAccount.java
│  │     │  ├─ Customer.java
│  │     │  ├─ InsufficientFundsException.java
│  │     │  └─ AccountOperations.java (if kept)
│  │     ├─ io/            (file I/O + parsing)
│  │     │  ├─ TransactionReader.java
│  │     │  ├─ TransactionParser.java
│  │     │  └─ TransactionLogger.java
│  │     └─ app/
│  │        └─ Main.java
│  └─ resources/
│     ├─ transactions-input.txt
│     └─ transactions-output.txt (optional example)
└─ test/
└─ java/ ... (optional but ideal)
