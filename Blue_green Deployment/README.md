# ansible_deployment
ANSIBLE HOSTGROUPS (Def location /etc/ansible/hosts):  
deploy1 => ANSIBLE host group for BLUE Side of App servers  
deploy2 => ANSIBLE host group for GREEN Side of App servers  
webservers => Ansible group for APACHE webservers
  
Variables (Include under nag_apa_bal/vars/main.yml):    
nagios => Nagios server HOSTNAME  
nagios_srv => Service name of nagios monitoring the application server  
war_src => patch of source war file to be deployed  
war_dst => destination path on tomcat server  
  
ansible-playbook deploy.yml
