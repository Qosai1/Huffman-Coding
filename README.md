# 📦 Huffman Coding Compression Tool

A Java-based file compression and decompression tool using **Huffman Coding**, developed as part of the *Design and Analysis of Algorithms (COM336)* course.

## 📚 Project Overview

Huffman Coding is a lossless data compression algorithm that assigns shorter codes to more frequent bytes and longer codes to less frequent ones. This project involves:
- Compressing any file using Huffman Coding.
- Saving it with a custom binary format (including a header).
- Decompressing it back to the original state.

### 🎯 Goals
- Implement Huffman Coding from scratch.
- Build a binary tree and priority queue manually.
- Create a clean, user-friendly application interface.
- Ensure accurate decompression of files.

---

## 🧱 Project Structure

| File | Description |
|------|-------------|
| `Main.java` | Entry point of the application. |
| `GUI.java` | Graphical interface for compression and decompression. |
| `Compress.java` | Handles file encoding and compression. |
| `Decompress.java` | Handles file decoding and decompression. |
| `Counter.java` | Counts the frequency of each byte in the input file. |
| `Huffman.java` | Core algorithm logic: builds tree, encodes, decodes. |
| `Heap.java` | Custom min-heap (priority queue) implementation. |
| `Tree.java` | Builds the Huffman Tree using TreeNodes. |
| `TreeNode.java` | Represents a node in the Huffman Tree. |
| `Header.java` | Manages writing/reading header data (code mapping). |

---

## 💡 Features

- ⚙️ Custom Huffman Tree construction from byte frequencies.
- 📊 Frequency table and code mapping generation.
- 📦 File compression with binary output and header.
- 🔁 File decompression and byte-accurate recovery.
- 🖥️ Clean GUI for ease of use.
- 🧪 Verification: original and decompressed files are identical.

---

## 🧪 How It Works

1. **Compression**
   - Read the input file and count byte frequencies.
   - Build Huffman Tree and generate code table.
   - Encode file and save compressed output with header.

2. **Decompression**
   - Read header and reconstruct the Huffman Tree.
   - Decode the compressed bit stream using the tree.
   - Write the decompressed output.

---

## 🚀 Getting Started

### 🔧 Prerequisites
- Java JDK 8 or higher
- IntelliJ IDEA (recommended)

### ▶️ Running the Application

1. Clone this repository:
   ```bash
   git clone https://github.com/your-username/huffman-coding-tool.git
   cd huffman-coding-tool
Open the project in IntelliJ IDEA or your favorite Java IDE.

Compile and run Main.java.

Use the GUI to select files and start compressing/decompressing.

🖼️ Interface
The application provides a simple and intuitive GUI, where:

You can browse and select files.

View compression results and statistics.

Decompress previously compressed files with one click.

📁 Example
Original → sample.txt (5 KB)
Compressed → sample.huff (3 KB)
Decompressed → sample_out.txt (matches original)

📌 Notes
All processing and results are integrated into the GUI.

The project follows a modular design for clarity and maintainability.

No external libraries are used — everything is implemented from scratch.

🧑‍💻 Authors
Developed by [Qosai Badaha]

Course: COM336 - Design and Analysis of Algorithms

Semester: 2023/2024
