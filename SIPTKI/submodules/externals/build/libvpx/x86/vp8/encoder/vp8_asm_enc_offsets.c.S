	.file	"vp8_asm_enc_offsets.c"
	.text
.Ltext0:
	.section	.text.unlikely,"ax",@progbits
.LCOLDB0:
	.section	.text.startup,"ax",@progbits
.LHOTB0:
	.p2align 4,,15
	.section	.text.unlikely
.Ltext_cold0:
	.section	.text.startup
	.globl	main
	.type	main, @function
main:
.LFB95:
	.file 1 "/usr/src/easycall/releases/SIPtki/submodules/externals/libvpx/vp8/encoder/vp8_asm_enc_offsets.c"
	.loc 1 20 0
	.cfi_startproc
	.loc 1 23 0
#APP
# 23 "/usr/src/easycall/releases/SIPtki/submodules/externals/libvpx/vp8/encoder/vp8_asm_enc_offsets.c" 1
	
vp8_block_coeff EQU $4
# 0 "" 2
	.loc 1 24 0
# 24 "/usr/src/easycall/releases/SIPtki/submodules/externals/libvpx/vp8/encoder/vp8_asm_enc_offsets.c" 1
	
vp8_block_zbin EQU $20
# 0 "" 2
	.loc 1 25 0
# 25 "/usr/src/easycall/releases/SIPtki/submodules/externals/libvpx/vp8/encoder/vp8_asm_enc_offsets.c" 1
	
vp8_block_round EQU $28
# 0 "" 2
	.loc 1 26 0
# 26 "/usr/src/easycall/releases/SIPtki/submodules/externals/libvpx/vp8/encoder/vp8_asm_enc_offsets.c" 1
	
vp8_block_quant EQU $8
# 0 "" 2
	.loc 1 27 0
# 27 "/usr/src/easycall/releases/SIPtki/submodules/externals/libvpx/vp8/encoder/vp8_asm_enc_offsets.c" 1
	
vp8_block_quant_fast EQU $12
# 0 "" 2
	.loc 1 28 0
# 28 "/usr/src/easycall/releases/SIPtki/submodules/externals/libvpx/vp8/encoder/vp8_asm_enc_offsets.c" 1
	
vp8_block_zbin_extra EQU $32
# 0 "" 2
	.loc 1 29 0
# 29 "/usr/src/easycall/releases/SIPtki/submodules/externals/libvpx/vp8/encoder/vp8_asm_enc_offsets.c" 1
	
vp8_block_zrun_zbin_boost EQU $24
# 0 "" 2
	.loc 1 30 0
# 30 "/usr/src/easycall/releases/SIPtki/submodules/externals/libvpx/vp8/encoder/vp8_asm_enc_offsets.c" 1
	
vp8_block_quant_shift EQU $16
# 0 "" 2
	.loc 1 32 0
# 32 "/usr/src/easycall/releases/SIPtki/submodules/externals/libvpx/vp8/encoder/vp8_asm_enc_offsets.c" 1
	
vp8_blockd_qcoeff EQU $0
# 0 "" 2
	.loc 1 33 0
# 33 "/usr/src/easycall/releases/SIPtki/submodules/externals/libvpx/vp8/encoder/vp8_asm_enc_offsets.c" 1
	
vp8_blockd_dequant EQU $12
# 0 "" 2
	.loc 1 34 0
# 34 "/usr/src/easycall/releases/SIPtki/submodules/externals/libvpx/vp8/encoder/vp8_asm_enc_offsets.c" 1
	
vp8_blockd_dqcoeff EQU $4
# 0 "" 2
	.loc 1 35 0
# 35 "/usr/src/easycall/releases/SIPtki/submodules/externals/libvpx/vp8/encoder/vp8_asm_enc_offsets.c" 1
	
vp8_blockd_eob EQU $20
# 0 "" 2
	.loc 1 38 0
# 38 "/usr/src/easycall/releases/SIPtki/submodules/externals/libvpx/vp8/encoder/vp8_asm_enc_offsets.c" 1
	
vp8_block_base_src EQU $36
# 0 "" 2
	.loc 1 39 0
# 39 "/usr/src/easycall/releases/SIPtki/submodules/externals/libvpx/vp8/encoder/vp8_asm_enc_offsets.c" 1
	
vp8_block_src EQU $40
# 0 "" 2
	.loc 1 40 0
# 40 "/usr/src/easycall/releases/SIPtki/submodules/externals/libvpx/vp8/encoder/vp8_asm_enc_offsets.c" 1
	
vp8_block_src_diff EQU $0
# 0 "" 2
	.loc 1 41 0
# 41 "/usr/src/easycall/releases/SIPtki/submodules/externals/libvpx/vp8/encoder/vp8_asm_enc_offsets.c" 1
	
vp8_block_src_stride EQU $44
# 0 "" 2
	.loc 1 43 0
# 43 "/usr/src/easycall/releases/SIPtki/submodules/externals/libvpx/vp8/encoder/vp8_asm_enc_offsets.c" 1
	
vp8_blockd_predictor EQU $8
# 0 "" 2
	.loc 1 46 0
# 46 "/usr/src/easycall/releases/SIPtki/submodules/externals/libvpx/vp8/encoder/vp8_asm_enc_offsets.c" 1
	
vp8_writer_lowvalue EQU $0
# 0 "" 2
	.loc 1 47 0
# 47 "/usr/src/easycall/releases/SIPtki/submodules/externals/libvpx/vp8/encoder/vp8_asm_enc_offsets.c" 1
	
vp8_writer_range EQU $4
# 0 "" 2
	.loc 1 48 0
# 48 "/usr/src/easycall/releases/SIPtki/submodules/externals/libvpx/vp8/encoder/vp8_asm_enc_offsets.c" 1
	
vp8_writer_count EQU $8
# 0 "" 2
	.loc 1 49 0
# 49 "/usr/src/easycall/releases/SIPtki/submodules/externals/libvpx/vp8/encoder/vp8_asm_enc_offsets.c" 1
	
vp8_writer_pos EQU $12
# 0 "" 2
	.loc 1 50 0
# 50 "/usr/src/easycall/releases/SIPtki/submodules/externals/libvpx/vp8/encoder/vp8_asm_enc_offsets.c" 1
	
vp8_writer_buffer EQU $16
# 0 "" 2
	.loc 1 51 0
# 51 "/usr/src/easycall/releases/SIPtki/submodules/externals/libvpx/vp8/encoder/vp8_asm_enc_offsets.c" 1
	
vp8_writer_buffer_end EQU $20
# 0 "" 2
	.loc 1 52 0
# 52 "/usr/src/easycall/releases/SIPtki/submodules/externals/libvpx/vp8/encoder/vp8_asm_enc_offsets.c" 1
	
vp8_writer_error EQU $24
# 0 "" 2
	.loc 1 54 0
# 54 "/usr/src/easycall/releases/SIPtki/submodules/externals/libvpx/vp8/encoder/vp8_asm_enc_offsets.c" 1
	
tokenextra_token EQU $6
# 0 "" 2
	.loc 1 55 0
# 55 "/usr/src/easycall/releases/SIPtki/submodules/externals/libvpx/vp8/encoder/vp8_asm_enc_offsets.c" 1
	
tokenextra_extra EQU $4
# 0 "" 2
	.loc 1 56 0
# 56 "/usr/src/easycall/releases/SIPtki/submodules/externals/libvpx/vp8/encoder/vp8_asm_enc_offsets.c" 1
	
tokenextra_context_tree EQU $0
# 0 "" 2
	.loc 1 57 0
# 57 "/usr/src/easycall/releases/SIPtki/submodules/externals/libvpx/vp8/encoder/vp8_asm_enc_offsets.c" 1
	
tokenextra_skip_eob_node EQU $7
# 0 "" 2
	.loc 1 58 0
# 58 "/usr/src/easycall/releases/SIPtki/submodules/externals/libvpx/vp8/encoder/vp8_asm_enc_offsets.c" 1
	
TOKENEXTRA_SZ EQU $8
# 0 "" 2
	.loc 1 60 0
# 60 "/usr/src/easycall/releases/SIPtki/submodules/externals/libvpx/vp8/encoder/vp8_asm_enc_offsets.c" 1
	
vp8_extra_bit_struct_sz EQU $16
# 0 "" 2
	.loc 1 62 0
# 62 "/usr/src/easycall/releases/SIPtki/submodules/externals/libvpx/vp8/encoder/vp8_asm_enc_offsets.c" 1
	
vp8_token_value EQU $0
# 0 "" 2
	.loc 1 63 0
# 63 "/usr/src/easycall/releases/SIPtki/submodules/externals/libvpx/vp8/encoder/vp8_asm_enc_offsets.c" 1
	
vp8_token_len EQU $4
# 0 "" 2
	.loc 1 65 0
# 65 "/usr/src/easycall/releases/SIPtki/submodules/externals/libvpx/vp8/encoder/vp8_asm_enc_offsets.c" 1
	
vp8_extra_bit_struct_tree EQU $0
# 0 "" 2
	.loc 1 66 0
# 66 "/usr/src/easycall/releases/SIPtki/submodules/externals/libvpx/vp8/encoder/vp8_asm_enc_offsets.c" 1
	
vp8_extra_bit_struct_prob EQU $4
# 0 "" 2
	.loc 1 67 0
# 67 "/usr/src/easycall/releases/SIPtki/submodules/externals/libvpx/vp8/encoder/vp8_asm_enc_offsets.c" 1
	
vp8_extra_bit_struct_len EQU $8
# 0 "" 2
	.loc 1 68 0
# 68 "/usr/src/easycall/releases/SIPtki/submodules/externals/libvpx/vp8/encoder/vp8_asm_enc_offsets.c" 1
	
vp8_extra_bit_struct_base_val EQU $12
# 0 "" 2
	.loc 1 70 0
# 70 "/usr/src/easycall/releases/SIPtki/submodules/externals/libvpx/vp8/encoder/vp8_asm_enc_offsets.c" 1
	
vp8_comp_tplist EQU $143344
# 0 "" 2
	.loc 1 71 0
# 71 "/usr/src/easycall/releases/SIPtki/submodules/externals/libvpx/vp8/encoder/vp8_asm_enc_offsets.c" 1
	
vp8_comp_common EQU $106400
# 0 "" 2
	.loc 1 72 0
# 72 "/usr/src/easycall/releases/SIPtki/submodules/externals/libvpx/vp8/encoder/vp8_asm_enc_offsets.c" 1
	
vp8_comp_bc EQU $114368
# 0 "" 2
	.loc 1 73 0
# 73 "/usr/src/easycall/releases/SIPtki/submodules/externals/libvpx/vp8/encoder/vp8_asm_enc_offsets.c" 1
	
vp8_writer_sz EQU $36
# 0 "" 2
	.loc 1 75 0
# 75 "/usr/src/easycall/releases/SIPtki/submodules/externals/libvpx/vp8/encoder/vp8_asm_enc_offsets.c" 1
	
tokenlist_start EQU $0
# 0 "" 2
	.loc 1 76 0
# 76 "/usr/src/easycall/releases/SIPtki/submodules/externals/libvpx/vp8/encoder/vp8_asm_enc_offsets.c" 1
	
tokenlist_stop EQU $4
# 0 "" 2
	.loc 1 77 0
# 77 "/usr/src/easycall/releases/SIPtki/submodules/externals/libvpx/vp8/encoder/vp8_asm_enc_offsets.c" 1
	
TOKENLIST_SZ EQU $8
# 0 "" 2
	.loc 1 79 0
# 79 "/usr/src/easycall/releases/SIPtki/submodules/externals/libvpx/vp8/encoder/vp8_asm_enc_offsets.c" 1
	
vp8_common_mb_rows EQU $2216
# 0 "" 2
	.loc 1 81 0
#NO_APP
	xorl	%eax, %eax
	ret
	.cfi_endproc
.LFE95:
	.size	main, .-main
	.section	.text.unlikely
.LCOLDE0:
	.section	.text.startup
.LHOTE0:
	.text
.Letext0:
	.section	.text.unlikely
.Letext_cold0:
	.file 2 "/usr/src/easycall/releases/SIPtki/submodules/externals/libvpx/vp8/encoder/boolhuff.h"
	.section	.debug_info,"",@progbits
.Ldebug_info0:
	.long	0xce
	.value	0x4
	.long	.Ldebug_abbrev0
	.byte	0x4
	.uleb128 0x1
	.long	.LASF14
	.byte	0x1
	.long	.LASF15
	.long	.Ldebug_ranges0+0
	.long	0
	.long	.Ldebug_line0
	.uleb128 0x2
	.byte	0x4
	.byte	0x5
	.string	"int"
	.uleb128 0x3
	.byte	0x4
	.byte	0x7
	.long	.LASF0
	.uleb128 0x3
	.byte	0x4
	.byte	0x5
	.long	.LASF1
	.uleb128 0x3
	.byte	0x1
	.byte	0x6
	.long	.LASF2
	.uleb128 0x3
	.byte	0x1
	.byte	0x8
	.long	.LASF3
	.uleb128 0x3
	.byte	0x2
	.byte	0x5
	.long	.LASF4
	.uleb128 0x3
	.byte	0x2
	.byte	0x7
	.long	.LASF5
	.uleb128 0x3
	.byte	0x8
	.byte	0x5
	.long	.LASF6
	.uleb128 0x3
	.byte	0x8
	.byte	0x7
	.long	.LASF7
	.uleb128 0x3
	.byte	0x4
	.byte	0x7
	.long	.LASF8
	.uleb128 0x3
	.byte	0x1
	.byte	0x6
	.long	.LASF9
	.uleb128 0x3
	.byte	0x4
	.byte	0x7
	.long	.LASF10
	.uleb128 0x3
	.byte	0x8
	.byte	0x4
	.long	.LASF11
	.uleb128 0x4
	.long	0x3d
	.long	0x8c
	.uleb128 0x5
	.long	0x60
	.byte	0xff
	.byte	0
	.uleb128 0x6
	.long	.LASF16
	.byte	0x1
	.byte	0x14
	.long	0x21
	.long	.LFB95
	.long	.LFE95-.LFB95
	.uleb128 0x1
	.byte	0x9c
	.uleb128 0x4
	.long	0x28
	.long	0xb1
	.uleb128 0x5
	.long	0x60
	.byte	0xff
	.byte	0
	.uleb128 0x7
	.long	.LASF12
	.byte	0x2
	.byte	0x2c
	.long	0xbc
	.uleb128 0x8
	.long	0xa1
	.uleb128 0x7
	.long	.LASF13
	.byte	0x2
	.byte	0x2f
	.long	0xcc
	.uleb128 0x8
	.long	0x7c
	.byte	0
	.section	.debug_abbrev,"",@progbits
.Ldebug_abbrev0:
	.uleb128 0x1
	.uleb128 0x11
	.byte	0x1
	.uleb128 0x25
	.uleb128 0xe
	.uleb128 0x13
	.uleb128 0xb
	.uleb128 0x3
	.uleb128 0xe
	.uleb128 0x55
	.uleb128 0x17
	.uleb128 0x11
	.uleb128 0x1
	.uleb128 0x10
	.uleb128 0x17
	.byte	0
	.byte	0
	.uleb128 0x2
	.uleb128 0x24
	.byte	0
	.uleb128 0xb
	.uleb128 0xb
	.uleb128 0x3e
	.uleb128 0xb
	.uleb128 0x3
	.uleb128 0x8
	.byte	0
	.byte	0
	.uleb128 0x3
	.uleb128 0x24
	.byte	0
	.uleb128 0xb
	.uleb128 0xb
	.uleb128 0x3e
	.uleb128 0xb
	.uleb128 0x3
	.uleb128 0xe
	.byte	0
	.byte	0
	.uleb128 0x4
	.uleb128 0x1
	.byte	0x1
	.uleb128 0x49
	.uleb128 0x13
	.uleb128 0x1
	.uleb128 0x13
	.byte	0
	.byte	0
	.uleb128 0x5
	.uleb128 0x21
	.byte	0
	.uleb128 0x49
	.uleb128 0x13
	.uleb128 0x2f
	.uleb128 0xb
	.byte	0
	.byte	0
	.uleb128 0x6
	.uleb128 0x2e
	.byte	0
	.uleb128 0x3f
	.uleb128 0x19
	.uleb128 0x3
	.uleb128 0xe
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0xb
	.uleb128 0x27
	.uleb128 0x19
	.uleb128 0x49
	.uleb128 0x13
	.uleb128 0x11
	.uleb128 0x1
	.uleb128 0x12
	.uleb128 0x6
	.uleb128 0x40
	.uleb128 0x18
	.uleb128 0x2117
	.uleb128 0x19
	.byte	0
	.byte	0
	.uleb128 0x7
	.uleb128 0x34
	.byte	0
	.uleb128 0x3
	.uleb128 0xe
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0xb
	.uleb128 0x49
	.uleb128 0x13
	.uleb128 0x3f
	.uleb128 0x19
	.uleb128 0x3c
	.uleb128 0x19
	.byte	0
	.byte	0
	.uleb128 0x8
	.uleb128 0x26
	.byte	0
	.uleb128 0x49
	.uleb128 0x13
	.byte	0
	.byte	0
	.byte	0
	.section	.debug_aranges,"",@progbits
	.long	0x1c
	.value	0x2
	.long	.Ldebug_info0
	.byte	0x4
	.byte	0
	.value	0
	.value	0
	.long	.LFB95
	.long	.LFE95-.LFB95
	.long	0
	.long	0
	.section	.debug_ranges,"",@progbits
.Ldebug_ranges0:
	.long	.LFB95
	.long	.LFE95
	.long	0
	.long	0
	.section	.debug_line,"",@progbits
.Ldebug_line0:
	.section	.debug_str,"MS",@progbits,1
.LASF6:
	.string	"long long int"
.LASF0:
	.string	"unsigned int"
.LASF15:
	.string	"/usr/src/easycall/releases/SIPtki/submodules/externals/libvpx/vp8/encoder/vp8_asm_enc_offsets.c"
.LASF16:
	.string	"main"
.LASF10:
	.string	"long unsigned int"
.LASF12:
	.string	"vp8_prob_cost"
.LASF9:
	.string	"char"
.LASF7:
	.string	"long long unsigned int"
.LASF3:
	.string	"unsigned char"
.LASF13:
	.string	"vp8_norm"
.LASF1:
	.string	"long int"
.LASF11:
	.string	"double"
.LASF14:
	.string	"GNU C 4.9 20140827 (prerelease) -mssse3 -fno-short-enums -mbionic -fPIC -m32 -mtune=intel -march=i686 -g -O3"
.LASF5:
	.string	"short unsigned int"
.LASF2:
	.string	"signed char"
.LASF4:
	.string	"short int"
.LASF8:
	.string	"sizetype"
	.ident	"GCC: (GNU) 4.9 20140827 (prerelease)"
	.section	.note.GNU-stack,"",@progbits
