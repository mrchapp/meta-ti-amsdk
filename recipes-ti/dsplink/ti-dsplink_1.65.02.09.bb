require ti-dsplink.inc

DEPENDS_da830-omapl137-evm += "ti-ipc"

PE = "1"
PV = "1_65_02_09"
PV_dot = "1.65.02.09"
PV_major = "1_65"

PV_DL_PATH = "DSPLink/${PV_major}/${PV}/${PV_dot}"

# o brother, where art thou?
SRC_URI = "http://t3500wsk1.am.dhcp.ti.com/~x0019444/da830-evm/dsplink_linux_${PV}.tar.gz;name=dsplinktarball \
           file://ti-dsplink-examples-run.sh \
           file://ti-dsplink-examples-loadmodules.sh \
           file://ti-dsplink-examples-unloadmodules.sh "

LIC_FILES_CHKSUM = "file://dsplink_1_65_02_09_Manifest.html;md5=d132d38631ded567c42bb88d06c67ce7"
SRC_URI += "file://dsplink_1_65_02_09-missingheader.patch"

SRC_URI[dsplinktarball.md5sum] = "3be12a3e6bea8f4c1096a903df6a07a1"
SRC_URI[dsplinktarball.sha256sum] = "2ad37effabd7edfd72cf2c39883212d423fd4430e78551e9ec87cf6b39af4b65"
