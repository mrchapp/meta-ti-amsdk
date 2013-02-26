require ti-cgt6x.inc

LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=62f46f1125a152a2e213b414db7ac600"

PE = "1"
PV = "6_1_13"
PVwithdots = "6.1.13"

SRC_URI = "http://t3500wsk1.am.dhcp.ti.com/~x0019444/da830-evm/ti_cgt_c6000_${PVwithdots}_setup_linux_x86.bin;name=cgt6xbin"

SRC_URI[cgt6xbin.md5sum] = "fa78809065eddf29aed552d8d87456ef"
SRC_URI[cgt6xbin.sha256sum] = "9f633499eb0d8089bab098e00466977e15411ff7b8457ffacd724ba2ac335133"
