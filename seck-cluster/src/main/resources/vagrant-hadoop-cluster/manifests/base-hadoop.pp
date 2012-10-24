include hadoop

group { "puppet":
  ensure => "present",
}

exec { 'apt-get update':
  path => $path,
  command => 'apt-get update',
}

package { "openjdk-6-jdk":
  ensure => "present",
  require => Exec['apt-get update']
}

package { "maven2":
  ensure => "present",
  require => Exec['apt-get update']
}

file { "/etc/hosts":
  source => "puppet:///modules/hadoop/hosts",
  mode => 644,
  owner => root,
  group => root,
}

file { "/etc/timezone":
  source => "puppet:///modules/hadoop/timezone",
  mode => 644,
  owner => root,
  group => root,
}

file { "/root/.ssh":
  ensure  => directory,
  owner   => root,
  group   => root,
  mode    => 700,
}

file { "/etc/profile.d/set_java_home.sh":
  source => "puppet:///modules/hadoop/set_java_home.sh",
  mode => 644,
  owner => root,
  group => root,
  require => Exec['apt-get update']
}

file { "/root/.ssh/known_hosts":
  source => "puppet:///modules/hadoop/known_hosts",
  mode => 644,
  owner => root,
  group => root,
  require => Exec['apt-get update']
}

file { "/root/.ssh/id_rsa":
  source => "puppet:///modules/hadoop/id_rsa",
  mode => 600,
  owner => root,
  group => root,
  require => Exec['apt-get update']
}
 
file { "/root/.ssh/id_rsa.pub":
  source => "puppet:///modules/hadoop/id_rsa.pub",
  mode => 644,
  owner => root,
  group => root,
  require => Exec['apt-get update']
}

ssh_authorized_key { "ssh_key":
  ensure => "present",
  key    => "AAAAB3NzaC1yc2EAAAADAQABAAABAQCeHdBPVGuSPVOO+n94j/Y5f8VKGIAzjaDe30hu9BPetA+CGFpszw4nDkhyRtW5J9zhGKuzmcCqITTuM6BGpHax9ZKP7lRRjG8Lh380sCGA/691EjSVmR8krLvGZIQxeyHKpDBLEmcpJBB5yoSyuFpK+4RhmJLf7ImZA7mtxhgdPGhe6crUYRbLukNgv61utB/hbre9tgNX2giEurBsj9CI5yhPPNgq6iP8ZBOyCXgUNf37bAe7AjQUMV5G6JMZ1clEeNPN+Uy5Yrfojrx3wHfG40NuxuMrFIQo5qCYa3q9/SVOxsJILWt+hZ2bbxdGcQOd9AXYFNNowPayY0BdAkSr",
  type   => "ssh-rsa",
  user   => "root",
  require => File['/root/.ssh/id_rsa.pub']
}

