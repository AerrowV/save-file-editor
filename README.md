# SaveFileEditor

## Description

SaveFileEditor is a Java-based tool designed to decode, modify, and re-encode save files that are Base64-encoded and zlib-compressed. This tool allows users to decrypt their save files, edit values such as in-game currency, and then re-encrypt them to maintain compatibility with the original game.

## Features

- **Decode Save Files**: Reads Base64-encoded and zlib-compressed save files.
- **Modify Values**: Allows users to edit save file data (e.g., modify in-game money values).
- **Re-encode and Compress**: Compresses the modified file and converts it back to its original format.
- **Supports Java**: Written in Java for cross-platform compatibility.

## Prerequisites

- Java 8 or later installed
- A save file in Base64 + zlib format

## Installation

1. Clone the repository:
   ```sh
   git clone https://github.com/YOUR_GITHUB_USERNAME/SaveFileEditor.git
   cd SaveFileEditor
   ```
2. Compile the project:
   ```sh
   javac -d out -sourcepath src/main/java src/main/java/editor/SaveFileDecoder.java src/main/java/editor/Main.java src/main/java/editor/SaveFileEncoder.java
   ```

## Usage

### 1. Decode the Save File

```sh
java -cp out editor.SaveFileDecoder
```

- This will create a **`decrypted_save.txt`** file containing the decoded save data.

### 2. Modify the Save File

- Open **`decrypted_save.txt`** in a text editor.
- Locate and modify the values (e.g., change money value **`9988328`** to **`1000000000000`**).
- Save the file.

### 3. Re-encode the Save File

```sh
java -cp out editor.SaveFileEncoder
```

- This will create a **`saveslot_2_modified.save`** file.

### 4. Replace the Save File in the Game

- Replace your old save file with the newly generated **`saveslot_2_modified.save`**.
- Start the game and check if the modifications worked.

## Troubleshooting

### "Illegal Base64 character" error

- Ensure the save file is actually Base64-encoded. Open it in a text editor and confirm it consists of readable Base64 characters (**`A-Z`**, **`a-z`**, **`0-9`**, **`+`**, **`/`**, **`=`**).

### "NoSuchFileException"

- Make sure the save file is in the correct directory before running the program.
- Use absolute paths if necessary.

### "Corrupted Save File After Modification"

- Ensure only numeric values are modified without altering the file structure.
- Use a text editor that does not change file encoding (e.g., Notepad++, VS Code).

## Contributing

Pull requests are welcome. If you find a bug or have feature suggestions, please open an issue on GitHub.

## Contact

For any issues, reach out via GitHub or open a discussion in the repository.

---
