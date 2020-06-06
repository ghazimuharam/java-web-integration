<?php
$query = $_GET['q'];
if($query == "")
    $query = "all";
shell_exec("cd json && javac Main.java");
$output = shell_exec("cd json && java Main ". $query);
echo $output;
