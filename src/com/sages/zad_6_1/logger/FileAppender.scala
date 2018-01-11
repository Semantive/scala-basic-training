package com.sages.zad_6_1.logger

import java.io.FileOutputStream

class FileAppender(path: String) extends StreamAppender(new FileOutputStream(path))
