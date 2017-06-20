-- start:  Generated for sys_message From Template: mysql.sql.vm



drop table if exists sys_message;

create table sys_message (

	id			char(32)		not null,
	title			varchar(100)		null,
	content			varchar(5000)		null,
	send_time			datetime		null,
	sender			char(32)		null,
	receiver			char(32)		null,
	read_flag			int		null,
	type			char(1)		null,
    primary key (id)
) ENGINE = InnoDB CHARACTER SET utf8 COLLATE utf8_general_ci;

-- end:  Generated for sys_message From Template: mysql.sql.vm
-- start:  Generated for sys_workflow_ins_proc From Template: mysql.sql.vm



drop table if exists sys_workflow_ins_proc;

create table sys_workflow_ins_proc (

	id			char(32)		not null,
	process_def_id			varchar(40)		null,
	process_state			char(1)		null,
	process_start			datetime		null,
	process_end			datetime		null,
	data_object_key			varchar(255)		null,
    primary key (id)
) ENGINE = InnoDB CHARACTER SET utf8 COLLATE utf8_general_ci;

-- end:  Generated for sys_workflow_ins_proc From Template: mysql.sql.vm
-- start:  Generated for sys_workflow_ins_task From Template: mysql.sql.vm




drop table if exists sys_workflow_ins_task;

create table sys_workflow_ins_task (

	id			char(32)		not null,
	operator			varchar(40)		null,
	task_operator			varchar(40)		null,
	instance_start			datetime		null,
	instance_end			datetime		null,
	instance_state			char(1)		null,
	receipt_org			varchar(255)		null,
	receipt_role			varchar(255)		null,
	receipt_user			varchar(255)		null,
	process_ins_id			char(32)		null,
	task_title			varchar(40)		null,
	state_def_id			varchar(40)		null,
    primary key (id)
) ENGINE = InnoDB CHARACTER SET utf8 COLLATE utf8_general_ci;

-- end:  Generated for sys_workflow_ins_task From Template: mysql.sql.vm
-- start:  Generated for sys_transmit From Template: mysql.sql.vm



drop table if exists sys_transmit;

create table sys_transmit (

	id			char(32)		not null,
	title			varchar(100)		null,
	data_object			varchar(40)		null,
	data_object_key			varchar(40)		null,
	form_layout			varchar(40)		null,
	start_time			datetime		null,
	sender			char(32)		null,
	end_time			datetime		null,
	end_flag			int		null,
    primary key (id)
) ENGINE = InnoDB CHARACTER SET utf8 COLLATE utf8_general_ci;

-- end:  Generated for sys_transmit From Template: mysql.sql.vm
-- start:  Generated for sys_transmit_detail From Template: mysql.sql.vm




drop table if exists sys_transmit_detail;

create table sys_transmit_detail (

	id			char(32)		not null,
	transmit_id			char(32)		null,
	read_flag			int		null,
	advice			varchar(5000)		null,
	transmit_time			datetime		null,
	receiver			char(32)		null,
    primary key (id)
) ENGINE = InnoDB CHARACTER SET utf8 COLLATE utf8_general_ci;

-- end:  Generated for sys_transmit_detail From Template: mysql.sql.vm
-- start:  Generated for sys_loginfo From Template: mysql.sql.vm



drop table if exists sys_loginfo;

create table sys_loginfo (

	id			char(32)		not null,
	operator			char(32)		null,
	operation_type			char(1)		null,
	operation_title			varchar(200)		null,
	operation_time			datetime		null,
	client_ip			varchar(20)		null,
	terminal_type			varchar(100)		null,
    primary key (id)
) ENGINE = InnoDB CHARACTER SET utf8 COLLATE utf8_general_ci;

-- end:  Generated for sys_loginfo From Template: mysql.sql.vm
-- start:  Generated for sys_daily_ins From Template: mysql.sql.vm



drop table if exists sys_daily_ins;

create table sys_daily_ins (

	id			char(32)		not null,
	event_type			varchar(32)		null,
	title			varchar(50)		null,
	url			varchar(250)		null,
	description			varchar(255)		null,
	define_date			datetime		null,
	user_id			char(32)		null,
	share_flag			char(1)		null,
	share_data			varchar(1000)		null,
    primary key (id)
) ENGINE = InnoDB CHARACTER SET utf8 COLLATE utf8_general_ci;

-- end:  Generated for sys_daily_ins From Template: mysql.sql.vm
-- start:  Generated for epc_ins_task From Template: mysql.sql.vm




drop table if exists epc_ins_task;

create table epc_ins_task (

	id			char(32)		not null,
	process_ins_id			char(32)		null,
	state_def_id			varchar(40)		null,
	task_title			varchar(40)		null,
	operator			varchar(40)		null,
	task_operator			varchar(40)		null,
	instance_start			datetime		null,
	instance_end			datetime		null,
	url			varchar(255)		null,
	instance_state			char(1)		null,
	receipt_org			varchar(255)		null,
	receipt_role			varchar(255)		null,
	receipt_user			varchar(255)		null,
    primary key (id)
) ENGINE = InnoDB CHARACTER SET utf8 COLLATE utf8_general_ci;

-- end:  Generated for epc_ins_task From Template: mysql.sql.vm
-- start:  Generated for epc_ins_proc From Template: mysql.sql.vm



drop table if exists epc_ins_proc;

create table epc_ins_proc (

	id			char(32)		not null,
	process_def_id			varchar(40)		null,
	process_state			char(1)		null,
	process_start			datetime		null,
	process_end			datetime		null,
	data_object			varchar(40)		null,
	data_object_key			varchar(40)		null,
    primary key (id)
) ENGINE = InnoDB CHARACTER SET utf8 COLLATE utf8_general_ci;

-- end:  Generated for epc_ins_proc From Template: mysql.sql.vm
-- start:  Generated for t_user_info From Template: mysql.sql.vm



drop table if exists t_user_info;

create table t_user_info (

	id			char(32)		not null,
	login_name			varchar(20)		null,
	name			varchar(20)		null,
	password			varchar(20)		null,
	email			varchar(20)		null,
	enable			int		null,
	organize_id			char(32)		null,
    primary key (id)
) ENGINE = InnoDB CHARACTER SET utf8 COLLATE utf8_general_ci;

-- end:  Generated for t_user_info From Template: mysql.sql.vm
-- start:  Generated for t_organize_info From Template: mysql.sql.vm



drop table if exists t_organize_info;

create table t_organize_info (

	id			char(32)		not null,
	name			varchar(255)		null,
	dw_flag			int		null,
	original_sort			varchar(1000)		null,
	global_sort			varchar(1000)		null,
	fwd_ins_id_cd			varchar(13)		null,
	parent_id			char(32)		null,
	organize_bm			varchar(20)		null,
	organize_level			int		null,
    primary key (id)
) ENGINE = InnoDB CHARACTER SET utf8 COLLATE utf8_general_ci;

-- end:  Generated for t_organize_info From Template: mysql.sql.vm
-- start:  Generated for t_role_info From Template: mysql.sql.vm



drop table if exists t_role_info;

create table t_role_info (

	id			char(32)		not null,
	name			varchar(20)		null,
	code			varchar(20)		null,
    primary key (id)
) ENGINE = InnoDB CHARACTER SET utf8 COLLATE utf8_general_ci;

-- end:  Generated for t_role_info From Template: mysql.sql.vm
-- start:  Generated for t_organize_user From Template: mysql.sql.vm



drop table if exists t_organize_user;

create table t_organize_user (

	id			char(32)		not null,
	organize_id			char(32)		null,
	user_id			char(32)		null,
	type			int		null,
    primary key (id)
) ENGINE = InnoDB CHARACTER SET utf8 COLLATE utf8_general_ci;

-- end:  Generated for t_organize_user From Template: mysql.sql.vm
-- start:  Generated for t_role_user From Template: mysql.sql.vm



drop table if exists t_role_user;

create table t_role_user (

	id			char(32)		not null,
	role_id			char(32)		null,
	user_id			varchar(20)		null,
    primary key (id)
) ENGINE = InnoDB CHARACTER SET utf8 COLLATE utf8_general_ci;

-- end:  Generated for t_role_user From Template: mysql.sql.vm
-- start:  Generated for t_rule_instance From Template: mysql.sql.vm



drop table if exists t_rule_instance;

create table t_rule_instance (

	id			char(32)		not null,
	enable			int		null,
	description			varchar(100)		null,
	cycle			varchar(20)		null,
	time_param			varchar(20)		null,
	need_trans_info			int		null,
	support_trace			int		null,
	type			varchar(2)		null,
	version_bm			varchar(20)		null,
	trans_info			int		null,
	code			varchar(20)		null,
	begin_trace_date			date		null,
	belong_to_inst			char(32)		null,
	end_trace_date			date		null,
    primary key (id)
) ENGINE = InnoDB CHARACTER SET utf8 COLLATE utf8_general_ci;

-- end:  Generated for t_rule_instance From Template: mysql.sql.vm
-- start:  Generated for t_rule From Template: mysql.sql.vm



drop table if exists t_rule;

create table t_rule (

	id			varchar(3)		not null,
	description			varchar(100)		null,
	support_trace			int		null,
	trans_info			int		null,
	type			char(1)		null,
	cycle			varchar(8)		null,
    primary key (id)
) ENGINE = InnoDB CHARACTER SET utf8 COLLATE utf8_general_ci;

-- end:  Generated for t_rule From Template: mysql.sql.vm
-- start:  Generated for t_cardbin From Template: mysql.sql.vm



drop table if exists t_cardbin;

create table t_cardbin (

	id			char(32)		not null,
	name			varchar(20)		null,
	length			int		null,
	bin			varchar(14)		null,
	cupscard			int		null,
	bank			varchar(100)		null,
    primary key (id)
) ENGINE = InnoDB CHARACTER SET utf8 COLLATE utf8_general_ci;

-- end:  Generated for t_cardbin From Template: mysql.sql.vm
-- start:  Generated for t_basearg From Template: mysql.sql.vm



drop table if exists t_basearg;

create table t_basearg (

	id			char(32)		not null,
	name			varchar(20)		null,
	type			varchar(20)		null,
	code			varchar(20)		null,
	param1			varchar(20)		null,
	param2			varchar(20)		null,
    primary key (id)
) ENGINE = InnoDB CHARACTER SET utf8 COLLATE utf8_general_ci;

-- end:  Generated for t_basearg From Template: mysql.sql.vm
-- start:  Generated for t_permission From Template: mysql.sql.vm



drop table if exists t_permission;

create table t_permission (

	id			char(32)		not null,
	privilede_id			varchar(32)		null,
	privilede_type			varchar(20)		null,
	role_id			char(32)		null,
    primary key (id)
) ENGINE = InnoDB CHARACTER SET utf8 COLLATE utf8_general_ci;

-- end:  Generated for t_permission From Template: mysql.sql.vm
-- start:  Generated for t_keo_mchnt From Template: mysql.sql.vm



drop table if exists t_keo_mchnt;

create table t_keo_mchnt (

	id			char(32)		not null,
	mchnt_cd			varchar(15)		null,
	reason			varchar(255)		null,
	mchnt_name			varchar(255)		null,
	type			varchar(255)		null,
	belong_to_inst			varchar(255)		null,
	sys_record_order		int			null,
    primary key (id)
) ENGINE = InnoDB CHARACTER SET utf8 COLLATE utf8_general_ci;

-- end:  Generated for t_keo_mchnt From Template: mysql.sql.vm
-- start:  Generated for t_rule_group From Template: mysql.sql.vm



drop table if exists t_rule_group;

create table t_rule_group (

	id			char(32)		not null,
	belong_to_inst			char(32)		null,
	description			varchar(255)		null,
	enable			int		null,
	status			varchar(2)		null,
    primary key (id)
) ENGINE = InnoDB CHARACTER SET utf8 COLLATE utf8_general_ci;

-- end:  Generated for t_rule_group From Template: mysql.sql.vm
-- start:  Generated for t_rule_instance_group From Template: mysql.sql.vm



drop table if exists t_rule_instance_group;

create table t_rule_instance_group (

	id			char(32)		not null,
	rule_group_id			char(32)		null,
	rule_instance_id			char(32)		null,
    primary key (id)
) ENGINE = InnoDB CHARACTER SET utf8 COLLATE utf8_general_ci;

-- end:  Generated for t_rule_instance_group From Template: mysql.sql.vm
-- start:  Generated for t_rule_instance_group_segment From Template: mysql.sql.vm



drop table if exists t_rule_instance_group_segment;

create table t_rule_instance_group_segment (

	id			char(32)		not null,
	propertion			decimal(5,2)		null,
	rule_instance_group_id			char(32)		null,
	begin			decimal(5,2)		null,
	end			decimal(5,2)		null,
	rule_instance_id			char(32)		null,
	value			decimal(12,1)		null,
    primary key (id)
) ENGINE = InnoDB CHARACTER SET utf8 COLLATE utf8_general_ci;

-- end:  Generated for t_rule_instance_group_segment From Template: mysql.sql.vm
-- start:  Generated for t_mchnt From Template: mysql.sql.vm




drop table if exists t_mchnt;

create table t_mchnt (

	merchantcategory			char(32)		null,
	id			varchar(40)		not null,
	foreigncard			varchar(20)		null,
	merchantnature			varchar(20)		null,
	name			varchar(255)		null,
	briefname			varchar(255)		null,
	engname			varchar(40)		null,
	engbriefname			varchar(255)		null,
	contractant			varchar(255)		null,
	licenseno			varchar(255)		null,
	registeredcapital			varchar(255)		null,
	taxno			varchar(255)		null,
	merchantno			varchar(15)		null,
	installdate			date		null,
	withdrawinputdate			date		null,
	subinst			varchar(255)		null,
	developingmethod			varchar(20)		null,
	multiacquirer			int		null,
	businessacceptmethod			varchar(20)		null,
	state			varchar(20)		null,
	servicerate			varchar(20)		null,
	legalman			varchar(20)		null,
	idcardtype			varchar(255)		null,
	idcardno			varchar(255)		null,
	licensedeadline			date		null,
	register_address			varchar(255)		null,
	register_zipcode			varchar(20)		null,
	office_address			varchar(255)		null,
	office_zipcode			varchar(20)		null,
	contactperson			varchar(20)		null,
	dept			varchar(20)		null,
	tel			varchar(20)		null,
	mobtel			varchar(20)		null,
	fax			varchar(20)		null,
	email			varchar(20)		null,
	financeperson			varchar(20)		null,
	financetel			varchar(20)		null,
	financemotel			varchar(20)		null,
	financefax			varchar(20)		null,
	financeemail			varchar(20)		null,
	mailperson			varchar(20)		null,
	mailtel			varchar(20)		null,
	mailmobtel			varchar(20)		null,
	chargereduingtime			int		null,
	guaranteemethod			varchar(20)		null,
	guaranteemethoddesc			varchar(255)		null,
	approvedesc			varchar(255)		null,
	approveddate			date		null,
	addingcategory			varchar(255)		null,
	logoutinputdate			date		null,
	withdrawcategory			varchar(20)		null,
	withdrawoperator			varchar(20)		null,
	laststatechangedate			date		null,
	laststatechangeoperator			varchar(20)		null,
	province			varchar(20)		null,
	city			varchar(20)		null,
	county			varchar(20)		null,
	refusereason			varchar(20)		null,
	remark			varchar(255)		null,
    primary key (id)
) ENGINE = InnoDB CHARACTER SET utf8 COLLATE utf8_general_ci;

-- end:  Generated for t_mchnt From Template: mysql.sql.vm
-- start:  Generated for t_mchnt_app From Template: mysql.sql.vm





drop table if exists t_mchnt_app;

create table t_mchnt_app (

	mchnt_id			varchar(40)		null,
	apptype			varchar(255)		null,
	main			int		null,
	acquirer			varchar(255)		null,
	networktransferinst			varchar(255)		null,
	memberinstmerno			varchar(15)		null,
	depositbank			varchar(255)		null,
	settlementaccntname			varchar(255)		null,
	settlementaccntno			varchar(21)		null,
	belong_to_inst			char(32)		null,
	id			varchar(32)		not null,
    primary key (id)
) ENGINE = InnoDB CHARACTER SET utf8 COLLATE utf8_general_ci;

-- end:  Generated for t_mchnt_app From Template: mysql.sql.vm
-- start:  Generated for t_riskprocess_timelimit From Template: mysql.sql.vm




drop table if exists t_riskprocess_timelimit;

create table t_riskprocess_timelimit (

	belong_to_inst			char(32)		null,
	warn_level			varchar(255)		null,
	time_limit			varchar(40)		null,
	id			char(32)		not null,
    primary key (id)
) ENGINE = InnoDB CHARACTER SET utf8 COLLATE utf8_general_ci;

-- end:  Generated for t_riskprocess_timelimit From Template: mysql.sql.vm
-- start:  Generated for t_riskcase_record From Template: mysql.sql.vm




drop table if exists t_riskcase_record;

create table t_riskcase_record (

	id			char(32)		not null,
	riskcase_id			char(32)		null,
	investigation_date			date		null,
	create_date			date		null,
	investigation_way			varchar(1)		null,
	is_pick_flow			int		null,
	pick_cnt			int		null,
	pick_amt			int		null,
	pick_180_cnt			int		null,
	pick_180_amt			int		null,
	pick_status			varchar(12)		null,
	pick_flaw_cnt			int		null,
	pick_empty_cnt			int		null,
	investigation_result			char(1)		null,
	risk_level			varchar(2)		null,
	risk_type			varchar(2)		null,
	process_type			varchar(2)		null,
	process_freeze_amt			int		null,
	process_withdraw_cnt			int		null,
	description			varchar(4000)		null,
	caseno			char(32)		null,
	user_id			varchar(40)		null,
	submit			int		null,
	other_investigation_way			varchar(255)		null,
	other_risk_type			varchar(255)		null,
	other_process_type			varchar(255)		null,
    primary key (id)
) ENGINE = InnoDB CHARACTER SET utf8 COLLATE utf8_general_ci;

-- end:  Generated for t_riskcase_record From Template: mysql.sql.vm
-- start:  Generated for t_trans_info From Template: mysql.sql.vm



drop table if exists t_trans_info;

create table t_trans_info (

	id			char(32)		not null,
	settle_dt			date		null,
	sys_tra_no			varchar(6)		null,
	resp_cd4			varchar(2)		null,
	trans_id			varchar(3)		null,
	settle_in			varchar(1)		null,
	trans_at			int		null,
	msg_tp			varchar(4)		null,
	loc_trans_dt_tm			varchar(10)		null,
	mchnt_tp			varchar(4)		null,
	retri_ref_no			varchar(12)		null,
	pri_acct_no			varchar(21)		null,
	bin			varchar(14)		null,
	card_attr			varchar(2)		null,
	card_media			varchar(1)		null,
	term_id			varchar(8)		null,
	mchnt_cd			varchar(15)		null,
	card_accptr_nm_loc			varchar(40)		null,
	acq_ins_id_cd			varchar(13)		null,
	fwd_ins_id_cd			varchar(13)		null,
	rcv_ins_id_cd			varchar(13)		null,
	iss_ins_id_cd			varchar(13)		null,
	orig_sys_tra_no			varchar(6)		null,
	orig_transmsn_dt_tm			varchar(10)		null,
	rsn_cd			varchar(4)		null,
	auth_dt			date		null,
	auth_id_resp_cd			varchar(7)		null,
	pos_entry_md_cd			varchar(3)		null,
	pos_cond_cd			varchar(2)		null,
	proc_cd			varchar(6)		null,
	settle_ym			varchar(6)		null,
	fwd_ins_id_original			varchar(13)		null,
    primary key (id)
) ENGINE = InnoDB CHARACTER SET utf8 COLLATE utf8_general_ci;

-- end:  Generated for t_trans_info From Template: mysql.sql.vm