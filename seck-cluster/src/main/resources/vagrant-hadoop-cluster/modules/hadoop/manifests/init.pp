class hadoop {
  $hadoop_home = "/opt/hadoop"
  $hadoop_version = "1.0.4"
  $hadoop_tarball = "http://apache.mirrors.pair.com/hadoop/common/hadoop-${hadoop_version}/hadoop-${hadoop_version}-bin.tar.gz"

exec { "download_hadoop":
  path => $path,
  command => "wget -O /tmp/hadoop.tar.gz $hadoop_tarball",
  unless => "ls /opt | grep hadoop-${hadoop_version}",
  require => Package["openjdk-6-jdk"]
}

exec { "unpack_hadoop" :
  path => $path,
  command => "tar -zxf /tmp/hadoop.tar.gz -C /opt",
  creates => "${hadoop_home}-${hadoop_version}",
  require => Exec["download_hadoop"]
}

file {
  "${hadoop_home}-${hadoop_version}/conf/slaves":
  source => "puppet:///modules/hadoop/slaves",
  mode => 644,
  owner => root,
  group => root,
  require => Exec["unpack_hadoop"]
 }
 
file {
  "${hadoop_home}-${hadoop_version}/conf/masters":
  source => "puppet:///modules/hadoop/masters",
  mode => 644,
  owner => root,
  group => root,
  require => Exec["unpack_hadoop"]
}

file {
  "${hadoop_home}-${hadoop_version}/conf/core-site.xml":
  source => "puppet:///modules/hadoop/core-site.xml",
  mode => 644,
  owner => root,
  group => root,
  require => Exec["unpack_hadoop"]
}
 
file {
  "${hadoop_home}-${hadoop_version}/conf/mapred-site.xml":
  source => "puppet:///modules/hadoop/mapred-site.xml",
  mode => 644,
  owner => root,
  group => root,
  require => Exec["unpack_hadoop"]
}
 
file {
  "${hadoop_home}-${hadoop_version}/conf/hdfs-site.xml":
  source => "puppet:///modules/hadoop/hdfs-site.xml",
  mode => 644,
  owner => root,
  group => root,
  require => Exec["unpack_hadoop"]
}
 
file {
  "${hadoop_home}-${hadoop_version}/conf/hadoop-env.sh":
  source => "puppet:///modules/hadoop/hadoop-env.sh",
  mode => 644,
  owner => root,
  group => root,
  require => Exec["unpack_hadoop"]
 }
}
