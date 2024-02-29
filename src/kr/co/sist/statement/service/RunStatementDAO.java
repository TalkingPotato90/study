package kr.co.sist.statement.service;

import kr.co.sist.statement.dao.StatementDAO;
import kr.co.sist.statement.vo.EmployeeVO;

import javax.swing.*;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

/**
 * CRUD를 사용하는 클래스
 */
public class RunStatementDAO {
    public void addEmp() {
        String inputData = JOptionPane.showInputDialog
                ("추가할 사원정보를 입력해주세요.\n사원번호, 사원명, 직무, 연봉");
        if (inputData != null) {
            String[] tempData = inputData.split(",");
            if (tempData.length != 4) {
                JOptionPane.showMessageDialog(null, "입력 형식을 확인해 주세요");
                return;
            }
            // 입력된 데이터를 하나로 묶어서 관리
            try {
                EmployeeVO employeeVO = new EmployeeVO(parseInt(tempData[0]),
                        tempData[1], tempData[2], parseDouble(tempData[3]), null);
                // DB에 추가하면 된다
                StatementDAO statementDAO = new StatementDAO();
                try {
                    statementDAO.insertEmp(employeeVO);
                    JOptionPane.showMessageDialog
                            (null, tempData[0] + "번 사원정보가 추가 되었습니다");
                } catch (SQLException se) {
                    se.printStackTrace();
                    String errMsg = "";
                    switch (se.getErrorCode()) {
                        case 1:
                            errMsg = "사원번호가 중복되었습니다.";
                            break;
                        case 1438:
                            errMsg = "연봉은 정수 5자리 실수 2자리로 입력 가능합니다.";
                            break;
                        case 12899:
                            errMsg = "사원명과 직무는 한글 3자까지만 가능합니다.";
                            break;
                        default:
                            errMsg = "문제가 발생했습니다.";
                    }
                    JOptionPane.showMessageDialog(null, errMsg);
                }

            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog
                        (null, "사원번호나 연봉은 숫자형태이어야 합니다.");
            }
        }
    }

    public void modifyEmp() {
        String inputData = JOptionPane.showInputDialog
                ("사원정보 변경\n사원번호,직무,연봉을 입력하면 사원번호에 해당하는 사원의 직무와 연봉을 변경합니다");
        if (inputData != null) {
            String[] tempData = inputData.split(",");
            if (tempData.length != 3) {
                JOptionPane.showMessageDialog
                        (null, "입력은 사원본호,직무,연봉의 형식입니다.");
                return;
            }

            try {
                EmployeeVO employeeVO = new EmployeeVO
                        (parseInt(tempData[0]), null, tempData[1],
                                parseDouble(tempData[2]), null);
                // DBMS에서 UPDATE 수행
                StatementDAO statementDAO = new StatementDAO();
                int cnt = statementDAO.updateEmp(employeeVO); // 0~n건 변경

                String msg = tempData[0] + "번 사원은 존재하지 않습니다. 사원번호를 확인해주세요.";
                if (cnt != 0) { // 1건 이상 변경 되었을 때
                    msg = tempData[0] + "번 으로 " + cnt + "건 변경 되었습니다.";
                }

                JOptionPane.showMessageDialog(null, msg);

            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "사원번호와 연봉은 숫자형태 입니다.");
            } catch (SQLException se) {
                se.printStackTrace();

                String errMsg = "";
                switch (se.getErrorCode()) {
                    case 1438:
                        errMsg = "연봉은 정수 5자리 실수 2자리로 입력 가능합니다.";
                        break;
                    case 12899:
                        errMsg = "직무는 한글 3자까지만 가능합니다.";
                        break;
                    default:
                        errMsg = "문제가 발생했습니다.";
                }
                JOptionPane.showMessageDialog(null, errMsg);
            }
        }
    }

    public void removeEmp() {
        String inputData = JOptionPane.showInputDialog("사원정보 삭제\n사원번호를 입력해 주세요");

        if (inputData == null) {
            JOptionPane.showMessageDialog(null, "사원번호를 입력해 주세요.");
            return;
        }

        try {
            int empno = parseInt(inputData);
            // DBMS에서 조회된 결과를 받아서 사용자에게 보여준다
            StatementDAO statementDAO = new StatementDAO();

            EmployeeVO employeeVO = statementDAO.selectOneEmp(empno);

            if (employeeVO == null) {
                JOptionPane.showMessageDialog(null, "입력하신 사원번호에 해당하는 사원이 없습니다.");
                return;
            }

            try {
                statementDAO.deleteEmp(empno);
                int option =JOptionPane.showConfirmDialog(null,empno+"번 사원정보를 삭제하시겠습니까?");
                if (option == JOptionPane.YES_OPTION) {
                    statementDAO.deleteEmp(empno);
                    JOptionPane.showMessageDialog(null, empno + "번 사원정보가 삭제 되었습니다");
                } else if (option == JOptionPane.NO_OPTION || option == JOptionPane.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(null, "사원정보 삭제가 취소되었습니다");
                }
            } catch (SQLException se) {
                se.printStackTrace();
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "사원번호는 숫자형태 이어야합니다.");
                return;
            }
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog
                    (null, "사원번호는 숫자형태이어야 합니다.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void searchAllEmp() {
        // DBMS에서 조회된 결과를 받아서 사용자에게 보여준다
        StatementDAO statementDAO = new StatementDAO();
        try {
            List<EmployeeVO> listAllEmp = statementDAO.selectAllEmp();
            StringBuilder output = new StringBuilder();
            output.append("사원번호\t사원명\t직무\t연봉\t입사일\n");

            if (listAllEmp.isEmpty()) {
                output.append("데이터가 없습니다.\uD83D\uDE31");
            } else {
                SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
                for (EmployeeVO employeeVO : listAllEmp) {
                    output.append(employeeVO.getEmpno()).append("\t")
                            .append(employeeVO.getEname()).append("\t")
                            .append(employeeVO.getJob()).append("\t")
                            .append(employeeVO.getSal()).append("\t")
                            .append(sdf.format(employeeVO.getHiredate())).append("\n");
                }
            }

            JTextArea jta = new JTextArea(output.toString(), 10, 80);
            JScrollPane jsp = new JScrollPane(jta);
            JOptionPane.showMessageDialog(null, jsp);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void searchOneEmp() {
        String inputData = JOptionPane.showInputDialog("사원검색\n사원번호를 입력해 주세요");

        if (inputData == null) {
            JOptionPane.showMessageDialog(null, "사원번호를 입력해 주세요.");
            return;
        }
        try {
            int empno = parseInt(inputData);
            // DBMS에서 조회된 결과를 받아서 사용자에게 보여준다
            StatementDAO statementDAO = new StatementDAO();

            EmployeeVO employeeVO = statementDAO.selectOneEmp(empno);

            StringBuilder output = new StringBuilder();
            output.append(empno).append("번 사원번호 검색 결과\n");
            if (employeeVO == null) {
                output.append("사원번호를 확인하세요.\uD83D\uDE31");
            } else {
                output.append("사원명 : ").append(employeeVO.getEname()).append("\n");
                output.append("직무 : ").append(employeeVO.getJob()).append("\n");
                output.append("연봉 : ").append(employeeVO.getSal()).append("\n");
                SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
                output.append("입사일 : ").append(sdf.format(employeeVO.getHiredate()));
            }

            JTextArea jta = new JTextArea(output.toString(), 10, 80);
            JScrollPane jsp = new JScrollPane(jta);
            JOptionPane.showMessageDialog(null, jsp);

        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "사원번호는 숫자형태 이어야합니다.");
            return;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void menu() {
        boolean exitFlag = false;
        String inputMenu = "";

        do {
            inputMenu = JOptionPane.showInputDialog
                    ("메뉴 선택\n1.사원정보추가 2.사원정보변경 3.사원정보삭제 4.전체사원검색 5.특정사원검색 6.종료");

            if (inputMenu != null) {
                switch (inputMenu) {
                    case "1":
                        addEmp();
                        break;
                    case "2":
                        modifyEmp();
                        break;
                    case "3":
                        removeEmp();
                        break;
                    case "4":
                        searchAllEmp();
                        break;
                    case "5":
                        searchOneEmp();
                        break;
                    case "6":
                        exitFlag = true;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "메뉴는 1,2,3,4,5,6 중 하나만 입력해 주세요");
                }
            }
        } while (!exitFlag);
    }

    public static void main(String[] args) {
        RunStatementDAO runStatementDAO = new RunStatementDAO();
        runStatementDAO.menu();
    }
}
