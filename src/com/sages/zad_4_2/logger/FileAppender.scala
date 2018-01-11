package com.sages.zad_4_2.logger

import java.io.FileOutputStream

class FileAppender(path: String) extends StreamAppender(new FileOutputStream(path))
