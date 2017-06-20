-- start:  Generated for sys_message From Template: sqlserver.sql.vm
/*==============================================================*/
/* Table: sys_message											*/	
/*==============================================================*/

if exists (select 1
            from  sysobjects
           where  id = object_id('sys_message')
            and   type = 'U')
   drop table sys_message
go

create table sys_message (
	[id]			char(32)		not null,
	[title]			varchar(100)		null,
	[content]			varchar(5000)		null,
	[send_time]			datetime		null,
	[sender]			char(32)		null,
	[receiver]			char(32)		null,
	[read_flag]			int		null,
	[type]			char(1)		null,
	constraint PK_SYS_MESSAGE primary key (id)
)
go

-- end:  Generated for sys_message From Template: sqlserver.sql.vm
-- start:  Generated for sys_workflow_ins_proc From Template: sqlserver.sql.vm
/*==============================================================*/
/* Table: sys_workflow_ins_proc											*/	
/*==============================================================*/

if exists (select 1
            from  sysobjects
           where  id = object_id('sys_workflow_ins_proc')
            and   type = 'U')
   drop table sys_workflow_ins_proc
go

create table sys_workflow_ins_proc (
	[id]			char(32)		not null,
	[process_def_id]			varchar(40)		null,
	[process_state]			char(1)		null,
	[process_start]			datetime		null,
	[process_end]			datetime		null,
	[data_object_key]			varchar(255)		null,
	constraint PK_SYS_WORKFLOW_INS_PROC primary key (id)
)
go

-- end:  Generated for sys_workflow_ins_proc From Template: sqlserver.sql.vm
-- start:  Generated for sys_workflow_ins_task From Template: sqlserver.sql.vm
/*==============================================================*/
/* Table: sys_workflow_ins_task											*/	
/*==============================================================*/

if exists (select 1
            from  sysobjects
           where  id = object_id('sys_workflow_ins_task')
            and   type = 'U')
   drop table sys_workflow_ins_task
go

create table sys_workflow_ins_task (
	[id]			char(32)		not null,
	[operator]			varchar(40)		null,
	[task_operator]			varchar(40)		null,
	[instance_start]			datetime		null,
	[instance_end]			datetime		null,
	[instance_state]			char(1)		null,
	[receipt_org]			varchar(255)		null,
	[receipt_role]			varchar(255)		null,
	[receipt_user]			varchar(255)		null,
	[process_ins_id]			char(32)		null,
	[task_title]			varchar(40)		null,
	[state_def_id]			varchar(40)		null,
--	foreign key(process_ins_id) references syst02000001ums_risk(id),
	constraint PK_SYS_WORKFLOW_INS_TASK primary key (id)
)
go

-- end:  Generated for sys_workflow_ins_task From Template: sqlserver.sql.vm
-- start:  Generated for sys_transmit From Template: sqlserver.sql.vm
/*==============================================================*/
/* Table: sys_transmit											*/	
/*==============================================================*/

if exists (select 1
            from  sysobjects
           where  id = object_id('sys_transmit')
            and   type = 'U')
   drop table sys_transmit
go

create table sys_transmit (
	[id]			char(32)		not null,
	[title]			varchar(100)		null,
	[data_object]			varchar(40)		null,
	[data_object_key]			varchar(40)		null,
	[form_layout]			varchar(40)		null,
	[start_time]			datetime		null,
	[sender]			char(32)		null,
	[end_time]			datetime		null,
	[end_flag]			int		null,
	constraint PK_SYS_TRANSMIT primary key (id)
)
go

-- end:  Generated for sys_transmit From Template: sqlserver.sql.vm
-- start:  Generated for sys_transmit_detail From Template: sqlserver.sql.vm
/*==============================================================*/
/* Table: sys_transmit_detail											*/	
/*==============================================================*/

if exists (select 1
            from  sysobjects
           where  id = object_id('sys_transmit_detail')
            and   type = 'U')
   drop table sys_transmit_detail
go

create table sys_transmit_detail (
	[id]			char(32)		not null,
	[transmit_id]			char(32)		null,
	[read_flag]			int		null,
	[advice]			varchar(5000)		null,
	[transmit_time]			datetime		null,
	[receiver]			char(32)		null,
--	foreign key(transmit_id) references syst02000004ums_risk(id),
	constraint PK_SYS_TRANSMIT_DETAIL primary key (id)
)
go

-- end:  Generated for sys_transmit_detail From Template: sqlserver.sql.vm
-- start:  Generated for sys_loginfo From Template: sqlserver.sql.vm
/*==============================================================*/
/* Table: sys_loginfo											*/	
/*==============================================================*/

if exists (select 1
            from  sysobjects
           where  id = object_id('sys_loginfo')
            and   type = 'U')
   drop table sys_loginfo
go

create table sys_loginfo (
	[id]			char(32)		not null,
	[operator]			char(32)		null,
	[operation_type]			char(1)		null,
	[operation_title]			varchar(200)		null,
	[operation_time]			datetime		null,
	[client_ip]			varchar(20)		null,
	[terminal_type]			varchar(100)		null,
	constraint PK_SYS_LOGINFO primary key (id)
)
go

-- end:  Generated for sys_loginfo From Template: sqlserver.sql.vm
-- start:  Generated for sys_daily_ins From Template: sqlserver.sql.vm
/*==============================================================*/
/* Table: sys_daily_ins											*/	
/*==============================================================*/

if exists (select 1
            from  sysobjects
           where  id = object_id('sys_daily_ins')
            and   type = 'U')
   drop table sys_daily_ins
go

create table sys_daily_ins (
	[id]			char(32)		not null,
	[event_type]			varchar(32)		null,
	[title]			varchar(50)		null,
	[url]			varchar(250)		null,
	[description]			varchar(255)		null,
	[define_date]			datetime		null,
	[user_id]			char(32)		null,
	[share_flag]			char(1)		null,
	[share_data]			varchar(1000)		null,
	constraint PK_SYS_DAILY_INS primary key (id)
)
go

-- end:  Generated for sys_daily_ins From Template: sqlserver.sql.vm
-- start:  Generated for epc_ins_task From Template: sqlserver.sql.vm
/*==============================================================*/
/* Table: epc_ins_task											*/	
/*==============================================================*/

if exists (select 1
            from  sysobjects
           where  id = object_id('epc_ins_task')
            and   type = 'U')
   drop table epc_ins_task
go

create table epc_ins_task (
	[id]			char(32)		not null,
	[process_ins_id]			char(32)		null,
	[state_def_id]			varchar(40)		null,
	[task_title]			varchar(40)		null,
	[operator]			varchar(40)		null,
	[task_operator]			varchar(40)		null,
	[instance_start]			datetime		null,
	[instance_end]			datetime		null,
	[url]			varchar(255)		null,
	[instance_state]			char(1)		null,
	[receipt_org]			varchar(255)		null,
	[receipt_role]			varchar(255)		null,
	[receipt_user]			varchar(255)		null,
--	foreign key(process_ins_id) references syst02000012ums_risk(id),
	constraint PK_EPC_INS_TASK primary key (id)
)
go

-- end:  Generated for epc_ins_task From Template: sqlserver.sql.vm
-- start:  Generated for epc_ins_proc From Template: sqlserver.sql.vm
/*==============================================================*/
/* Table: epc_ins_proc											*/	
/*==============================================================*/

if exists (select 1
            from  sysobjects
           where  id = object_id('epc_ins_proc')
            and   type = 'U')
   drop table epc_ins_proc
go

create table epc_ins_proc (
	[id]			char(32)		not null,
	[process_def_id]			varchar(40)		null,
	[process_state]			char(1)		null,
	[process_start]			datetime		null,
	[process_end]			datetime		null,
	[data_object]			varchar(40)		null,
	[data_object_key]			varchar(40)		null,
	constraint PK_EPC_INS_PROC primary key (id)
)
go

-- end:  Generated for epc_ins_proc From Template: sqlserver.sql.vm
-- start:  Generated for t_user_info From Template: sqlserver.sql.vm
/*==============================================================*/
/* Table: t_user_info											*/	
/*==============================================================*/

if exists (select 1
            from  sysobjects
           where  id = object_id('t_user_info')
            and   type = 'U')
   drop table t_user_info
go

create table t_user_info (
	[id]			char(32)		not null,
	[login_name]			varchar(20)		null,
	[name]			varchar(20)		null,
	[password]			varchar(20)		null,
	[email]			varchar(20)		null,
	[enable]			int		null,
	[organize_id]			char(32)		null,
	constraint PK_T_USER_INFO primary key (id)
)
go

-- end:  Generated for t_user_info From Template: sqlserver.sql.vm
-- start:  Generated for t_organize_info From Template: sqlserver.sql.vm
/*==============================================================*/
/* Table: t_organize_info											*/	
/*==============================================================*/

if exists (select 1
            from  sysobjects
           where  id = object_id('t_organize_info')
            and   type = 'U')
   drop table t_organize_info
go

create table t_organize_info (
	[id]			char(32)		not null,
	[name]			varchar(255)		null,
	[dw_flag]			int		null,
	[original_sort]			varchar(1000)		null,
	[global_sort]			varchar(1000)		null,
	[fwd_ins_id_cd]			varchar(13)		null,
	[parent_id]			char(32)		null,
	[organize_bm]			varchar(20)		null,
	[organize_level]			int		null,
	constraint PK_T_ORGANIZE_INFO primary key (id)
)
go

-- end:  Generated for t_organize_info From Template: sqlserver.sql.vm
-- start:  Generated for t_role_info From Template: sqlserver.sql.vm
/*==============================================================*/
/* Table: t_role_info											*/	
/*==============================================================*/

if exists (select 1
            from  sysobjects
           where  id = object_id('t_role_info')
            and   type = 'U')
   drop table t_role_info
go

create table t_role_info (
	[id]			char(32)		not null,
	[name]			varchar(20)		null,
	[code]			varchar(20)		null,
	constraint PK_T_ROLE_INFO primary key (id)
)
go

-- end:  Generated for t_role_info From Template: sqlserver.sql.vm
-- start:  Generated for t_organize_user From Template: sqlserver.sql.vm
/*==============================================================*/
/* Table: t_organize_user											*/	
/*==============================================================*/

if exists (select 1
            from  sysobjects
           where  id = object_id('t_organize_user')
            and   type = 'U')
   drop table t_organize_user
go

create table t_organize_user (
	[id]			char(32)		not null,
	[organize_id]			char(32)		null,
	[user_id]			char(32)		null,
	[type]			int		null,
	constraint PK_T_ORGANIZE_USER primary key (id)
)
go

-- end:  Generated for t_organize_user From Template: sqlserver.sql.vm
-- start:  Generated for t_role_user From Template: sqlserver.sql.vm
/*==============================================================*/
/* Table: t_role_user											*/	
/*==============================================================*/

if exists (select 1
            from  sysobjects
           where  id = object_id('t_role_user')
            and   type = 'U')
   drop table t_role_user
go

create table t_role_user (
	[id]			char(32)		not null,
	[role_id]			char(32)		null,
	[user_id]			varchar(20)		null,
	constraint PK_T_ROLE_USER primary key (id)
)
go

-- end:  Generated for t_role_user From Template: sqlserver.sql.vm
-- start:  Generated for t_rule_instance From Template: sqlserver.sql.vm
/*==============================================================*/
/* Table: t_rule_instance											*/	
/*==============================================================*/

if exists (select 1
            from  sysobjects
           where  id = object_id('t_rule_instance')
            and   type = 'U')
   drop table t_rule_instance
go

create table t_rule_instance (
	[id]			char(32)		not null,
	[enable]			int		null,
	[description]			varchar(100)		null,
	[cycle]			varchar(20)		null,
	[time_param]			varchar(20)		null,
	[need_trans_info]			int		null,
	[support_trace]			int		null,
	[type]			varchar(2)		null,
	[version_bm]			varchar(20)		null,
	[trans_info]			int		null,
	[code]			varchar(20)		null,
	[begin_trace_date]			date		null,
	[belong_to_inst]			char(32)		null,
	[end_trace_date]			date		null,
	constraint PK_T_RULE_INSTANCE primary key (id)
)
go

-- end:  Generated for t_rule_instance From Template: sqlserver.sql.vm
-- start:  Generated for t_rule From Template: sqlserver.sql.vm
/*==============================================================*/
/* Table: t_rule											*/	
/*==============================================================*/

if exists (select 1
            from  sysobjects
           where  id = object_id('t_rule')
            and   type = 'U')
   drop table t_rule
go

create table t_rule (
	[id]			varchar(3)		not null,
	[description]			varchar(100)		null,
	[support_trace]			int		null,
	[trans_info]			int		null,
	[type]			char(1)		null,
	[cycle]			varchar(8)		null,
	constraint PK_T_RULE primary key (id)
)
go

-- end:  Generated for t_rule From Template: sqlserver.sql.vm
-- start:  Generated for t_cardbin From Template: sqlserver.sql.vm
/*==============================================================*/
/* Table: t_cardbin											*/	
/*==============================================================*/

if exists (select 1
            from  sysobjects
           where  id = object_id('t_cardbin')
            and   type = 'U')
   drop table t_cardbin
go

create table t_cardbin (
	[id]			char(32)		not null,
	[name]			varchar(20)		null,
	[length]			int		null,
	[bin]			varchar(14)		null,
	[cupscard]			int		null,
	[bank]			varchar(100)		null,
	constraint PK_T_CARDBIN primary key (id)
)
go

-- end:  Generated for t_cardbin From Template: sqlserver.sql.vm
-- start:  Generated for t_basearg From Template: sqlserver.sql.vm
/*==============================================================*/
/* Table: t_basearg											*/	
/*==============================================================*/

if exists (select 1
            from  sysobjects
           where  id = object_id('t_basearg')
            and   type = 'U')
   drop table t_basearg
go

create table t_basearg (
	[id]			char(32)		not null,
	[name]			varchar(20)		null,
	[type]			varchar(20)		null,
	[code]			varchar(20)		null,
	[param1]			varchar(20)		null,
	[param2]			varchar(20)		null,
	constraint PK_T_BASEARG primary key (id)
)
go

-- end:  Generated for t_basearg From Template: sqlserver.sql.vm
-- start:  Generated for t_permission From Template: sqlserver.sql.vm
/*==============================================================*/
/* Table: t_permission											*/	
/*==============================================================*/

if exists (select 1
            from  sysobjects
           where  id = object_id('t_permission')
            and   type = 'U')
   drop table t_permission
go

create table t_permission (
	[id]			char(32)		not null,
	[privilede_id]			varchar(32)		null,
	[privilede_type]			varchar(20)		null,
	[role_id]			char(32)		null,
	constraint PK_T_PERMISSION primary key (id)
)
go

-- end:  Generated for t_permission From Template: sqlserver.sql.vm
-- start:  Generated for t_keo_mchnt From Template: sqlserver.sql.vm
/*==============================================================*/
/* Table: t_keo_mchnt											*/	
/*==============================================================*/

if exists (select 1
            from  sysobjects
           where  id = object_id('t_keo_mchnt')
            and   type = 'U')
   drop table t_keo_mchnt
go

create table t_keo_mchnt (
	[id]			char(32)		not null,
	[mchnt_cd]			varchar(15)		null,
	[reason]			varchar(255)		null,
	[mchnt_name]			varchar(255)		null,
	[type]			varchar(255)		null,
	[belong_to_inst]			varchar(255)		null,
	sys_record_order		int			null,
	constraint PK_T_KEO_MCHNT primary key (id)
)
go

-- end:  Generated for t_keo_mchnt From Template: sqlserver.sql.vm
-- start:  Generated for t_rule_group From Template: sqlserver.sql.vm
/*==============================================================*/
/* Table: t_rule_group											*/	
/*==============================================================*/

if exists (select 1
            from  sysobjects
           where  id = object_id('t_rule_group')
            and   type = 'U')
   drop table t_rule_group
go

create table t_rule_group (
	[id]			char(32)		not null,
	[belong_to_inst]			char(32)		null,
	[description]			varchar(255)		null,
	[enable]			int		null,
	[status]			varchar(2)		null,
	constraint PK_T_RULE_GROUP primary key (id)
)
go

-- end:  Generated for t_rule_group From Template: sqlserver.sql.vm
-- start:  Generated for t_rule_instance_group From Template: sqlserver.sql.vm
/*==============================================================*/
/* Table: t_rule_instance_group											*/	
/*==============================================================*/

if exists (select 1
            from  sysobjects
           where  id = object_id('t_rule_instance_group')
            and   type = 'U')
   drop table t_rule_instance_group
go

create table t_rule_instance_group (
	[id]			char(32)		not null,
	[rule_group_id]			char(32)		null,
	[rule_instance_id]			char(32)		null,
	constraint PK_T_RULE_INSTANCE_GROUP primary key (id)
)
go

-- end:  Generated for t_rule_instance_group From Template: sqlserver.sql.vm
-- start:  Generated for t_rule_instance_group_segment From Template: sqlserver.sql.vm
/*==============================================================*/
/* Table: t_rule_instance_group_segment											*/	
/*==============================================================*/

if exists (select 1
            from  sysobjects
           where  id = object_id('t_rule_instance_group_segment')
            and   type = 'U')
   drop table t_rule_instance_group_segment
go

create table t_rule_instance_group_segment (
	[id]			char(32)		not null,
	[propertion]			decimal(5,2)		null,
	[rule_instance_group_id]			char(32)		null,
	[begin]			decimal(5,2)		null,
	[end]			decimal(5,2)		null,
	[rule_instance_id]			char(32)		null,
	[value]			decimal(12,1)		null,
	constraint PK_T_RULE_INSTANCE_GROUP_SEGMENT primary key (id)
)
go

-- end:  Generated for t_rule_instance_group_segment From Template: sqlserver.sql.vm
-- start:  Generated for t_mchnt From Template: sqlserver.sql.vm
/*==============================================================*/
/* Table: t_mchnt											*/	
/*==============================================================*/

if exists (select 1
            from  sysobjects
           where  id = object_id('t_mchnt')
            and   type = 'U')
   drop table t_mchnt
go

create table t_mchnt (
	[merchantcategory]			char(32)		null,
	[id]			varchar(40)		not null,
	[foreigncard]			varchar(20)		null,
	[merchantnature]			varchar(20)		null,
	[name]			varchar(255)		null,
	[briefname]			varchar(255)		null,
	[engname]			varchar(40)		null,
	[engbriefname]			varchar(255)		null,
	[contractant]			varchar(255)		null,
	[licenseno]			varchar(255)		null,
	[registeredcapital]			varchar(255)		null,
	[taxno]			varchar(255)		null,
	[merchantno]			varchar(15)		null,
	[installdate]			date		null,
	[withdrawinputdate]			date		null,
	[subinst]			varchar(255)		null,
	[developingmethod]			varchar(20)		null,
	[multiacquirer]			int		null,
	[businessacceptmethod]			varchar(20)		null,
	[state]			varchar(20)		null,
	[servicerate]			varchar(20)		null,
	[legalman]			varchar(20)		null,
	[idcardtype]			varchar(255)		null,
	[idcardno]			varchar(255)		null,
	[licensedeadline]			date		null,
	[register_address]			varchar(255)		null,
	[register_zipcode]			varchar(20)		null,
	[office_address]			varchar(255)		null,
	[office_zipcode]			varchar(20)		null,
	[contactperson]			varchar(20)		null,
	[dept]			varchar(20)		null,
	[tel]			varchar(20)		null,
	[mobtel]			varchar(20)		null,
	[fax]			varchar(20)		null,
	[email]			varchar(20)		null,
	[financeperson]			varchar(20)		null,
	[financetel]			varchar(20)		null,
	[financemotel]			varchar(20)		null,
	[financefax]			varchar(20)		null,
	[financeemail]			varchar(20)		null,
	[mailperson]			varchar(20)		null,
	[mailtel]			varchar(20)		null,
	[mailmobtel]			varchar(20)		null,
	[chargereduingtime]			int		null,
	[guaranteemethod]			varchar(20)		null,
	[guaranteemethoddesc]			varchar(255)		null,
	[approvedesc]			varchar(255)		null,
	[approveddate]			date		null,
	[addingcategory]			varchar(255)		null,
	[logoutinputdate]			date		null,
	[withdrawcategory]			varchar(20)		null,
	[withdrawoperator]			varchar(20)		null,
	[laststatechangedate]			date		null,
	[laststatechangeoperator]			varchar(20)		null,
	[province]			varchar(20)		null,
	[city]			varchar(20)		null,
	[county]			varchar(20)		null,
	[refusereason]			varchar(20)		null,
	[remark]			varchar(255)		null,
--	foreign key(merchantcategory) references 2c908349169f7cda0116a40f5a14044b(id),
	constraint PK_T_MCHNT primary key (id)
)
go

-- end:  Generated for t_mchnt From Template: sqlserver.sql.vm
-- start:  Generated for t_mchnt_app From Template: sqlserver.sql.vm
/*==============================================================*/
/* Table: t_mchnt_app											*/	
/*==============================================================*/

if exists (select 1
            from  sysobjects
           where  id = object_id('t_mchnt_app')
            and   type = 'U')
   drop table t_mchnt_app
go

create table t_mchnt_app (
	[mchnt_id]			varchar(40)		null,
	[apptype]			varchar(255)		null,
	[main]			int		null,
	[acquirer]			varchar(255)		null,
	[networktransferinst]			varchar(255)		null,
	[memberinstmerno]			varchar(15)		null,
	[depositbank]			varchar(255)		null,
	[settlementaccntname]			varchar(255)		null,
	[settlementaccntno]			varchar(21)		null,
	[belong_to_inst]			char(32)		null,
	[id]			varchar(32)		not null,
--	foreign key(mchnt_id) references 2c908349169f7cda0116a330d8880049(id),
--	foreign key(belong_to_inst) references 2c908349169f7cda0116a4162798048d(id),
	constraint PK_T_MCHNT_APP primary key (id)
)
go

-- end:  Generated for t_mchnt_app From Template: sqlserver.sql.vm
-- start:  Generated for t_riskprocess_timelimit From Template: sqlserver.sql.vm
/*==============================================================*/
/* Table: t_riskprocess_timelimit											*/	
/*==============================================================*/

if exists (select 1
            from  sysobjects
           where  id = object_id('t_riskprocess_timelimit')
            and   type = 'U')
   drop table t_riskprocess_timelimit
go

create table t_riskprocess_timelimit (
	[belong_to_inst]			char(32)		null,
	[warn_level]			varchar(255)		null,
	[time_limit]			varchar(40)		null,
	[id]			char(32)		not null,
--	foreign key(belong_to_inst) references 2c908349169f7cda0116a4162798048d(id),
	constraint PK_T_RISKPROCESS_TIMELIMIT primary key (id)
)
go

-- end:  Generated for t_riskprocess_timelimit From Template: sqlserver.sql.vm
-- start:  Generated for t_riskcase_record From Template: sqlserver.sql.vm
/*==============================================================*/
/* Table: t_riskcase_record											*/	
/*==============================================================*/

if exists (select 1
            from  sysobjects
           where  id = object_id('t_riskcase_record')
            and   type = 'U')
   drop table t_riskcase_record
go

create table t_riskcase_record (
	[id]			char(32)		not null,
	[riskcase_id]			char(32)		null,
	[investigation_date]			date		null,
	[create_date]			date		null,
	[investigation_way]			varchar(1)		null,
	[is_pick_flow]			int		null,
	[pick_cnt]			int		null,
	[pick_amt]			int		null,
	[pick_180_cnt]			int		null,
	[pick_180_amt]			int		null,
	[pick_status]			varchar(12)		null,
	[pick_flaw_cnt]			int		null,
	[pick_empty_cnt]			int		null,
	[investigation_result]			char(1)		null,
	[risk_level]			varchar(2)		null,
	[risk_type]			varchar(2)		null,
	[process_type]			varchar(2)		null,
	[process_freeze_amt]			int		null,
	[process_withdraw_cnt]			int		null,
	[description]			varchar(4000)		null,
	[caseno]			char(32)		null,
	[user_id]			varchar(40)		null,
	[submit]			int		null,
	[other_investigation_way]			varchar(255)		null,
	[other_risk_type]			varchar(255)		null,
	[other_process_type]			varchar(255)		null,
--	foreign key(riskcase_id) references 2c908349169f7cda0116a3cdf8590126(id),
	constraint PK_T_RISKCASE_RECORD primary key (id)
)
go

-- end:  Generated for t_riskcase_record From Template: sqlserver.sql.vm
-- start:  Generated for t_trans_info From Template: sqlserver.sql.vm
/*==============================================================*/
/* Table: t_trans_info											*/	
/*==============================================================*/

if exists (select 1
            from  sysobjects
           where  id = object_id('t_trans_info')
            and   type = 'U')
   drop table t_trans_info
go

create table t_trans_info (
	[id]			char(32)		not null,
	[settle_dt]			date		null,
	[sys_tra_no]			varchar(6)		null,
	[resp_cd4]			varchar(2)		null,
	[trans_id]			varchar(3)		null,
	[settle_in]			varchar(1)		null,
	[trans_at]			int		null,
	[msg_tp]			varchar(4)		null,
	[loc_trans_dt_tm]			varchar(10)		null,
	[mchnt_tp]			varchar(4)		null,
	[retri_ref_no]			varchar(12)		null,
	[pri_acct_no]			varchar(21)		null,
	[bin]			varchar(14)		null,
	[card_attr]			varchar(2)		null,
	[card_media]			varchar(1)		null,
	[term_id]			varchar(8)		null,
	[mchnt_cd]			varchar(15)		null,
	[card_accptr_nm_loc]			varchar(40)		null,
	[acq_ins_id_cd]			varchar(13)		null,
	[fwd_ins_id_cd]			varchar(13)		null,
	[rcv_ins_id_cd]			varchar(13)		null,
	[iss_ins_id_cd]			varchar(13)		null,
	[orig_sys_tra_no]			varchar(6)		null,
	[orig_transmsn_dt_tm]			varchar(10)		null,
	[rsn_cd]			varchar(4)		null,
	[auth_dt]			date		null,
	[auth_id_resp_cd]			varchar(7)		null,
	[pos_entry_md_cd]			varchar(3)		null,
	[pos_cond_cd]			varchar(2)		null,
	[proc_cd]			varchar(6)		null,
	[settle_ym]			varchar(6)		null,
	[fwd_ins_id_original]			varchar(13)		null,
	constraint PK_T_TRANS_INFO primary key (id)
)
go

-- end:  Generated for t_trans_info From Template: sqlserver.sql.vm