<?php
shell_exec("cd json && javac Main.java");
$output = shell_exec("cd json && java Main all");
$file = fopen("allEditor.json", "w");
fwrite($file, $output);
fclose($file);
